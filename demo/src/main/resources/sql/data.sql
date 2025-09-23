-- 外部キー制約を無効化してから削除（ただし慎重に）
SET FOREIGN_KEY_CHECKS=0;

DELETE FROM orders;
DELETE FROM products;
DELETE FROM categories;
DELETE FROM makers;
DELETE FROM stores;

SET FOREIGN_KEY_CHECKS=1;
-- 他のテーブルも同様に


-- 外部キー制約を一時的に解除（重要！）
SET FOREIGN_KEY_CHECKS = 0;

-- カテゴリ全削除
DELETE FROM categories;

-- 外部キー制約を復活
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE IF NOT EXISTS categories (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  parent_id BIGINT,
  FOREIGN KEY (parent_id) REFERENCES categories(id)
);


-- 大カテゴリ
INSERT INTO categories (id, name, parent_id) VALUES (1, '冷蔵庫・洗濯機・掃除機', NULL);
INSERT INTO categories (id, name, parent_id) VALUES (2, '電子レンジ・炊飯器', NULL);
INSERT INTO categories (id, name, parent_id) VALUES (3, 'エアコン・空調', NULL);
INSERT INTO categories (id, name, parent_id) VALUES (4, 'テレビ・レコーダー', NULL);

-- 中カテゴリ
INSERT INTO categories (id, name, parent_id) VALUES (5, '冷蔵庫・冷凍庫', 1);
INSERT INTO categories (id, name, parent_id) VALUES (6, '洗濯機・洗濯乾燥機', 1);
INSERT INTO categories (id, name, parent_id) VALUES (7, '掃除機・クリーナー', 1);
INSERT INTO categories (id, name, parent_id) VALUES (8, 'オーブンレンジ・電子レンジ', 2);
INSERT INTO categories (id, name, parent_id) VALUES (9, '炊飯器', 2);
INSERT INTO categories (id, name, parent_id) VALUES (10, 'エアコン・窓用エアコン', 3);
INSERT INTO categories (id, name, parent_id) VALUES (11, '扇風機・サーキュレーター', 3);
INSERT INTO categories (id, name, parent_id) VALUES (12, '暖房器具', 3);
INSERT INTO categories (id, name, parent_id) VALUES (13, 'テレビ', 4);
INSERT INTO categories (id, name, parent_id) VALUES (14, 'レコーダー', 4);
INSERT INTO categories (id, name, parent_id) VALUES (15, 'プロジェクター', 4);

-- 小カテゴリ
INSERT INTO categories (id, name, parent_id) VALUES (16, '冷蔵庫', 5);
INSERT INTO categories (id, name, parent_id) VALUES (17, '冷凍庫', 5);
INSERT INTO categories (id, name, parent_id) VALUES (18, '保冷・冷温ボックス', 5);
INSERT INTO categories (id, name, parent_id) VALUES (19, '製氷機', 5);
INSERT INTO categories (id, name, parent_id) VALUES (20, '冷蔵庫関連品', 5);

INSERT INTO categories (id, name, parent_id) VALUES (21, 'ドラム式洗濯乾燥機', 6);
INSERT INTO categories (id, name, parent_id) VALUES (22, '縦型洗濯機', 6);
INSERT INTO categories (id, name, parent_id) VALUES (23, '2槽式洗濯機', 6);
INSERT INTO categories (id, name, parent_id) VALUES (24, 'ハンディ・小型洗濯機', 6);
INSERT INTO categories (id, name, parent_id) VALUES (25, '衣類乾燥機', 6);
INSERT INTO categories (id, name, parent_id) VALUES (26, '洗濯機関連品', 6);
INSERT INTO categories (id, name, parent_id) VALUES (27, '衣類乾燥機・関連品', 6);

INSERT INTO categories (id, name, parent_id) VALUES (28, 'スティッククリーナー', 7);
INSERT INTO categories (id, name, parent_id) VALUES (29, 'サイクロン式掃除機', 7);
INSERT INTO categories (id, name, parent_id) VALUES (30, '紙パック式掃除機', 7);
INSERT INTO categories (id, name, parent_id) VALUES (31, 'ロボット掃除機', 7);
INSERT INTO categories (id, name, parent_id) VALUES (32, 'ハンディクリーナー', 7);

INSERT INTO categories (id, name, parent_id) VALUES (33, '電子レンジ', 8);
INSERT INTO categories (id, name, parent_id) VALUES (34, 'オーブンレンジ', 8);
INSERT INTO categories (id, name, parent_id) VALUES (35, 'スチームオーブンレンジ', 8);

INSERT INTO categories (id, name, parent_id) VALUES (36, '保温ジャー', 9);
INSERT INTO categories (id, name, parent_id) VALUES (37, 'ガス炊飯器', 9);

INSERT INTO categories (id, name, parent_id) VALUES (38, 'エアコン', 10);
INSERT INTO categories (id, name, parent_id) VALUES (39, '窓用エアコン', 10);
INSERT INTO categories (id, name, parent_id) VALUES (40, 'エアコン関連品', 10);

INSERT INTO categories (id, name, parent_id) VALUES (41, 'リビング扇風機', 11);
INSERT INTO categories (id, name, parent_id) VALUES (42, 'タワー型扇風機', 11);
INSERT INTO categories (id, name, parent_id) VALUES (43, '羽根無し扇風機', 11);
INSERT INTO categories (id, name, parent_id) VALUES (44, 'サーキュレーター', 11);
INSERT INTO categories (id, name, parent_id) VALUES (45, '携帯型扇風機', 11);
INSERT INTO categories (id, name, parent_id) VALUES (46, '卓上型扇風機', 11);

INSERT INTO categories (id, name, parent_id) VALUES (47, '電気ファンヒーター', 12);
INSERT INTO categories (id, name, parent_id) VALUES (48, '電気ストーブ', 12);
INSERT INTO categories (id, name, parent_id) VALUES (49, 'セラミックヒーター', 12);
INSERT INTO categories (id, name, parent_id) VALUES (50, 'こたつ・こたつ布団', 12);
INSERT INTO categories (id, name, parent_id) VALUES (51, 'ホットカーペット・関連品', 12);

INSERT INTO categories (id, name, parent_id) VALUES (52, '液晶テレビ', 13);
INSERT INTO categories (id, name, parent_id) VALUES (53, '有機ELテレビ', 13);
INSERT INTO categories (id, name, parent_id) VALUES (54, 'ポータブルテレビ', 13);
INSERT INTO categories (id, name, parent_id) VALUES (55, 'テレビ関連品', 13);

INSERT INTO categories (id, name, parent_id) VALUES (56, 'ブルーレイレコーダー', 14);
INSERT INTO categories (id, name, parent_id) VALUES (57, 'HDDレコーダー', 14);
INSERT INTO categories (id, name, parent_id) VALUES (58, 'レコーダー関連品', 14);

INSERT INTO categories (id, name, parent_id) VALUES (59, 'プロジェクター本体', 15);
INSERT INTO categories (id, name, parent_id) VALUES (60, 'プロジェクター関連品', 15);
INSERT INTO categories (id, name, parent_id) VALUES (61, 'プロジェクタースクリーン', 15);
INSERT INTO categories (id, name, parent_id) VALUES (62, 'プロジェクタースクリーン関連品', 15);



-- makers
CREATE TABLE IF NOT EXISTS makers (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

-- メーカー情報を登録
INSERT INTO makers (id, name) VALUES
(1, '三角電機'),
(2, '夕立'),
(3, 'ダンソン'),
(4, 'Fanasonic'),
(5, 'DALNUDA'),
(6, '西芝'),
(7, 'gRobot'),
(8, 'マイリス・トーヤマ'),
(9, '虎印');


-- products
CREATE TABLE IF NOT EXISTS products (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  category_id BIGINT,
  maker_id BIGINT,
  price DOUBLE,
  stock_quantity INT,
  description TEXT
);

-- 修正後（OK）
INSERT INTO products (id, name, category_id, maker_id, price, stock_quantity, description) VALUES
(1, 'SR-IKJ-01',              5,  1, 0, 0, 'いい感じの冷蔵庫です'),             -- 冷蔵庫
(2, 'YDC-DSK-1001',           6,  2, 0, 0, 'いい感じのドラム式選択乾燥機です'),   -- ドラム式洗濯乾燥機
(3, 'danson-slim-01',        14, 3, 0, 0, 'いい感じのサイクロン式掃除機です'),     -- サイクロン式掃除機
(4, 'FD-1221',                6,  4, 0, 0, 'いい感じの電子レンジです'),           -- 電子レンジ
(5, 'FS-2001',               21, 4, 0, 0, 'いい感じの炊飯器です'),               -- 炊飯器（Fanasonic）
(6, 'DN-SOR-d1',             20, 5, 0, 0, 'いい感じのスチームオーブンレンジです'), -- スチームオーブンレンジ
(7, 'N-ETV-1111',            38, 6, 0, 0, 'いい感じの液晶テレビです'),           -- 液晶テレビ
(8, 'Poomba-01',             16, 7, 0, 0, 'いい感じのロボット掃除機です'),        -- ロボット掃除機
(9, 'MT-S01',                21, 8, 0, 0, 'いい感じの炊飯器です'),               -- 炊飯器（マイリス・トーヤマ）
(10, 'TZ-HJ-11',             22, 9, 0, 0, 'いい感じの保温ジャーです');           -- 保温ジャー

-- stores
CREATE TABLE IF NOT EXISTS stores (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  location VARCHAR(255)
);

INSERT INTO stores (id, name, location) VALUES
(1, '新宿店', '東京都新宿区1-1-1'),
(2, '渋谷店', '東京都渋谷区2-2-2'),
(3, '池袋店', '東京都豊島区3-3-3');


-- roles
CREATE TABLE IF NOT EXISTS roles (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255)
);

INSERT INTO roles (id, name) VALUES
(1, '店長'),
(2, '副店長'),
(3, 'スタッフ');


-- permissions
CREATE TABLE IF NOT EXISTS permissions (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255)
);

INSERT INTO permissions (id, name) VALUES
(1, '商品管理'),
(2, '在庫管理'),
(3, '発注管理');


-- admins
CREATE TABLE IF NOT EXISTS admins (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  role_id BIGINT,
  email VARCHAR(255)
);

INSERT INTO admins (id, name, role_id, email) VALUES
(1, '山田 太郎', 1, 'yamada@example.com'),
(2, '佐藤 花子', 2, 'sato@example.com');


-- stocks
CREATE TABLE IF NOT EXISTS stocks (
  id BIGINT PRIMARY KEY,
  product_id BIGINT,
  store_id BIGINT,
  quantity INT
);

INSERT INTO stocks (id, product_id, store_id, quantity) VALUES
(1, 1, 1, 2),
(2, 2, 1, 1),
(3, 3, 2, 3),
(4, 4, 3, 5);


-- orders
CREATE TABLE IF NOT EXISTS orders (
  id BIGINT PRIMARY KEY,
  product_id BIGINT,
  store_id BIGINT, 
  quantity INT,
  order_date DATE,
  status VARCHAR(50),
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (store_id) REFERENCES stores(id)
);

INSERT INTO orders (id, product_id, quantity, order_date, status) VALUES
(1, 1, 2, '2025-09-01', '処理中'),
(2, 3, 1, '2025-09-05', '完了');


