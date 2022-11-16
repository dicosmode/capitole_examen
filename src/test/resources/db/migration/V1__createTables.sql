CREATE TABLE IF NOT EXISTS Brands (
                                      brand_id INT NOT NULL AUTO_INCREMENT,
                                      brand_name VARCHAR(45) NOT NULL,
                                      PRIMARY KEY (brand_id))
    ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS Prices (
                                      price_id INT NOT NULL AUTO_INCREMENT,
                                      brand_id INT NOT NULL,
                                      start_date DATETIME NOT NULL,
                                      end_date DATETIME NOT NULL,
                                      price_list INT NOT NULL,
                                      product_id INT NOT NULL,
                                      priority INT NOT NULL,
                                      price DECIMAL(20,2) NOT NULL,
                                      curr VARCHAR(4) NOT NULL,
                                      PRIMARY KEY (price_id),
                                      CONSTRAINT fk_brand_id
                                          FOREIGN KEY (brand_id)
                                              REFERENCES Brands (brand_id))
    ENGINE=InnoDB;
