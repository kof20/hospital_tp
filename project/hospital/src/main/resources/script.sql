CREATE SCHEMA `hospital`;


CREATE TABLE `hospital`.`doctor`
(
    `id_doctor`     INT         NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(45) NULL,
    `id_department` INT         NULL,
    PRIMARY KEY (`id_doctor`)
);

CREATE TABLE `hospital`.`patient`
(
    `id_patient`  INT         NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45) NULL,
    `surname`     VARCHAR(45) NULL,
    `dateofbirth` VARCHAR(45) NULL,
    `surname`     VARCHAR(45) NULL,
    `telephone`   VARCHAR(60) NULL,
    `id_doctor`   INT         NULL,
    `id_card`     INT         NULL,
    PRIMARY KEY (`id_patient`)
);


CREATE TABLE `hospital`.`department`
(
    `id_department` INT         NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(45) NULL,
    PRIMARY KEY (`id_department`)
);


CREATE TABLE `hospital`.`card`
(
    `id_card`    INT         NOT NULL AUTO_INCREMENT,
    `disease`    VARCHAR(45) NULL,
    `id_patient` INT         NULL,
    `id_doctor`  INT         NULL,
    PRIMARY KEY (`id_card`),
    CONSTRAINT `fk_doctror`
        FOREIGN KEY (`id_doctor`)
            REFERENCES `hospital`.`doctor` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

ALTER TABLE `hospital`.`patient`
    ADD CONSTRAINT `id_card`
        FOREIGN KEY (`id_card`)
            REFERENCES `hospital`.`card` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT `id_doctor`
        FOREIGN KEY (`id_doctor`)
            REFERENCES `hospital`.`doctor` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;


ALTER TABLE `hospital`.`doctor`
    ADD CONSTRAINT `gk_department`
        FOREIGN KEY (`id_department`)
            REFERENCES `hospital`.`department` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;