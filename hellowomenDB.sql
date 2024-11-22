

CREATE DATABASE("hellowomen")

CREATE TABLE roles (
    idRole SERIAL PRIMARY KEY,
    roleName VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE users (
    idUser SERIAL PRIMARY KEY,
    userName VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idRole INT,
    CONSTRAINT fk_user FOREIGN KEY (idRole) REFERENCES roles(idRole)
);

CREATE TABLE specialization (
    idSpecialization SERIAL PRIMARY KEY,
    labelSpecialization VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE doctors(
	idDoctor SERIAL PRIMARY KEY,
 	name VARCHAR(255) NOT NULL UNIQUE,
 	prenom VARCHAR(255) NOT NULL,
   idUser INT,
   idSpecialization INT,
 	CONSTRAINT fk_user_doc FOREIGN KEY (idUser) REFERENCES users(idUser),
  	CONSTRAINT fk_spec_doc FOREIGN KEY (idSpecialization) REFERENCES specialization(idSpecialization)
);

CREATE TABLE consultation(
	idConsultation SERIAL PRIMARY KEY,
 	anonyme boolean,
   idDoctor INT,
   idUser INT,
 	CONSTRAINT fk_cons_doc FOREIGN KEY (idDoctor) REFERENCES doctors(idDoctor),
  	CONSTRAINT fk_cons_user FOREIGN KEY (idUser) REFERENCES users(idUser)
);


CREATE TABLE contactsproche(
	idContact SERIAL PRIMARY KEY,
 	contact VARCHAR,
   idUser INT,
  	CONSTRAINT fk_cont_user FOREIGN KEY (idUser) REFERENCES users(idUser)
);


CREATE TABLE messages(
	idMessage SERIAL PRIMARY KEY,
 	contenu VARCHAR,
 	idConsultation INT,
   idDoctor INT,
   idUser INT,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 	CONSTRAINT fk_msg_doc FOREIGN KEY (idDoctor) REFERENCES doctors(idDoctor),
 	CONSTRAINT fk_msg_cons FOREIGN KEY (idConsultation) REFERENCES consultation(idConsultation),
  	CONSTRAINT fk_msg_user FOREIGN KEY (idUser) REFERENCES users(idUser)
);
