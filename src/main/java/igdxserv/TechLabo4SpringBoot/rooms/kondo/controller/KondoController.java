package igdxserv.TechLabo4SpringBoot.rooms.kondo.controller;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import igdxserv.TechLabo4SpringBoot.rooms.kondo.dto.SampleDto;
import igdxserv.TechLabo4SpringBoot.rooms.kondo.record.SlackChannelRerocd;
import igdxserv.TechLabo4SpringBoot.rooms.kondo.service.IKondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// import org.springframework.web.bind.annotation.RestController;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
// import com.box.sdk.BoxUploadFile; // Removed unused import
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
@RequestMapping("rooms/kondo")
public class KondoController {

    // get env variable
    private static final String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");

    @Autowired
    IKondoService kondoService;

    @RequestMapping("home")
    public String home(Model model) {
        String name = kondoService.getName(" Page!");
        String message = "Hello ".concat(name);
        model.addAttribute("message", message);
        return "rooms/kondo/main";
    }

    @RequestMapping("list")
    public String list(Model model) {
        List<SampleDto> sampleDtoList = new ArrayList<>();

        sampleDtoList.add(createData("data1", 10, 1000, true));
        sampleDtoList.add(createData("data2", 50, 500, true));
        sampleDtoList.add(createData("data3", 30, 700, false));

        model.addAttribute("sampleList", sampleDtoList);
        return "rooms/kondo/list";
    }

    @RequestMapping("slackapi/channel")
    public String slackapiChannelList(Model model) {
        List<SlackChannelRerocd> channnelList = kondoService.getChannlelList();
        model.addAttribute("channelList", channnelList);

        return "rooms/kondo/slackapi/channel";
    }

    @RequestMapping("boxapi/create")
    public String boxapiCreate(Model model) {
        try {
            System.out.println("Box APIを使用してファイルをアップロードします");
            // Boxから既存のExcelファイルをダウンロード
            byte[] existingFileData = downloadFileFromBox("SampleFromJava.xlsx");

            System.out.println("ファイルのダウンロードが完了しました");

            // 新しいシートを追加
            byte[] updatedFileData = addSheetToExcelFile(existingFileData);

            System.out.println("新しいシートの追加が完了しました");
            // Boxにアップロード
            uploadFileToBox(updatedFileData, "SampleFromJava.xlsx");

            System.out.println("end");

            model.addAttribute("message", "ファイルが正常にアップロードされました");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "ファイルのアップロードに失敗しました: " + e.getMessage());
        }

        return "rooms/kondo/boxapi/create";
    }

    private byte[] downloadFileFromBox(String fileName) throws Exception {
        BoxAPIConnection api = new BoxAPIConnection(ACCESS_TOKEN);
        BoxFolder rootFolder = BoxFolder.getRootFolder(api);

        System.out.println("ファイルをダウンロードします: " + fileName);

        for (BoxItem.Info itemInfo : rootFolder) {
            if (itemInfo instanceof BoxFile.Info && itemInfo.getName().equals(fileName)) {
                System.out.println("ファイルが見つかりました: " + fileName);
                BoxFile file = new BoxFile(api, itemInfo.getID());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                file.download(outputStream);
                return outputStream.toByteArray();
            }
        }
        throw new Exception("ファイルが見つかりません: " + fileName);
    }

    private byte[] addSheetToExcelFile(byte[] fileData) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(fileData);
        Workbook workbook = new XSSFWorkbook(inputStream);

        // 新しいシートを追加
        String sheetName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Sheet sheet = workbook.createSheet(sheetName);

        Row headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("Text");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Num");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Cnt");
        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("Flg");

        // サンプルデータを追加
        List<SampleDto> sampleDtoList = getSampleData();
        int rowNum = 1;
        for (SampleDto sample : sampleDtoList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(sample.getText());
            row.createCell(1).setCellValue(sample.getNum());
            row.createCell(2).setCellValue(sample.getCnt());
            row.createCell(3).setCellValue(sample.isFlg());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }

    private void uploadFileToBox(byte[] fileData, String fileName) throws Exception {
        BoxAPIConnection api = new BoxAPIConnection(ACCESS_TOKEN);
        BoxFolder rootFolder = BoxFolder.getRootFolder(api);

        // 既存のファイルを検索
        for (BoxItem.Info itemInfo : rootFolder) {
            if (itemInfo instanceof BoxFile.Info && itemInfo.getName().equals(fileName)) {
                BoxFile file = new BoxFile(api, itemInfo.getID());
                InputStream stream = new ByteArrayInputStream(fileData);
                file.uploadNewVersion(stream);
                return;
            }
        }

        // 新規ファイルとしてアップロード
        InputStream stream = new ByteArrayInputStream(fileData);
        rootFolder.uploadFile(stream, fileName);
    }

    private List<SampleDto> getSampleData() {
        // サンプルデータを返すメソッド
        // ここでは既存のsampleDtoListを返すと仮定
        SampleDto sampleData1 = createData("data1", 10, 1000, true);
        SampleDto sampleData2 = createData("data2", 50, 500, true);
        SampleDto sampleData3 = createData("data3", 30, 700, false);

        List<SampleDto> sampleDtoList = new ArrayList<>();
        sampleDtoList.add(sampleData1);
        sampleDtoList.add(sampleData2);
        sampleDtoList.add(sampleData3);

        return sampleDtoList;
    }

    private SampleDto createData(String text, int num, long cnt, boolean flg) {
        SampleDto sampleData = new SampleDto();
        sampleData.setText(text);
        sampleData.setCnt(cnt);
        sampleData.setNum(num);
        sampleData.setFlg(flg);
        sampleData.setRegDate(new Date());

        return sampleData;
    }
}
