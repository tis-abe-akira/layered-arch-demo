# レイヤードアーキテクチャ デモプロジェクト

このプロジェクトは、レイヤードアーキテクチャの効果を示すためのデモアプリケーションです。
同じ機能を持つアプリケーションを、レイヤードアーキテクチャとノンレイヤードアーキテクチャの2つの方式で実装し、その違いを比較できます。

## 機能概要

- ローン計算機能
  - 元本、年利率、返済期間（月）を入力
  - 毎月の返済額、総返済額、総利息を計算
  - アモチゼーション方式で計算

## プロジェクト構成

### レイヤードアーキテクチャ版 (`layered-arch/`)

```
src/main/java/com/example/layered/
├── controller/    # プレゼンテーション層
├── service/       # ビジネスロジック層
├── repository/    # データアクセス層
├── entity/        # データモデル
└── model/         # 画面用モデル
```

- 各層の責務が明確に分離
- データの永続化（H2データベース使用）
- 疎結合な設計
- テストが容易
- 保守性が高い

### ノンレイヤードアーキテクチャ版 (`non-layered-arch/`)

```
src/main/java/com/example/nonlayered/
└── controller/    # 全ての処理をコントローラーに集約
```

- シンプルな構造
- 全ての処理を1つのクラスに集約
- データの永続化なし
- 結合度が高い
- テストが困難
- 保守性が低い

## 技術スタック

- Java 17
- Spring Boot 3.2.3
- Thymeleaf
- H2 Database (レイヤード版のみ)
- Lombok
- Maven

## 実行方法

### レイヤード版

```bash
cd layered-arch
./mvnw spring-boot:run
```

### ノンレイヤード版

```bash
cd non-layered-arch
./mvnw spring-boot:run
```

両方とも http://localhost:8080 でアクセス可能です。
（同時に実行する場合は、ポート番号の競合に注意してください）

## アーキテクチャの比較

### レイヤード版の利点
- 責務の分離により、コードの見通しが良い
- 各層を独立してテスト可能
- 変更の影響範囲が限定的
- 機能追加や変更が容易

### ノンレイヤード版の特徴
- シンプルで理解しやすい初期構造
- 少ないファイル数で実装可能
- 小規模なアプリケーションでは開発が早い
- ただし、規模が大きくなると保守が困難に

## ライセンス

MIT 
