package igdxserv.TechLabo4SpringBoot.rooms.kondo.trial;

import igdxserv.TechLabo4SpringBoot.rooms.kondo.dto.SampleDto;
import igdxserv.TechLabo4SpringBoot.rooms.kondo.dto.SampleDtoEx;

/**
 * お試し用クラス
 */
public class Trial extends AbstructTrialBase implements  I_Trial {

    public String getNewText(SampleDto dto) {
        return dto.getText().concat("_NEW");
    }

    /**
     * 子クラスのDTOを渡してもエラーにならないか確認
     */
    public void trial001() {
        // 親DTO
        SampleDto dto = new SampleDto();
        dto.setText("SampleDTO");
        // 子DTO
        SampleDtoEx dtoex = new SampleDtoEx();
        dtoex.setText("SampleDTOEX");

        // 実行
        System.out.println(getNewText(dto));
        System.out.printf(getNewText(dtoex));

    }

    /**
     * テンプレートメソッド
     */
    public void trial099() {

    }




}
