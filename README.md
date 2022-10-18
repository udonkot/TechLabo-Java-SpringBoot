# TechLabo-Java-SpringBoot

## 前提
以下がローカルPCにインストールされていること

・JDK17
※環境変数(jAVA_HOME)も設定済であること

・Git

## 実行方法
1. リポジトリのクローンを作成し、developブランチに切り替える。

```
git clone https://github.com/udonkot/TechLabo-Java-SpringBoot.git
git checkout develop
```

2. クローンしたフォルダに移動

3. 以下コマンドを実行

```
mvnw clean install
mvnw spring-boot:run
```

4. localhost:8080にアクセス

## 作業時
・featureブランチを作成すること。ベースはdevelopブランチ。
・ブランチ名は「feature-[ユーザ名]」

