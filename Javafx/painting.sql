DROP TABLE painting   ;

CREATE TABLE painting    (
   paintingID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   artist varchar (30),
   name varchar (30)  NOT NULL,
   paintingyear INT,
   PRIMARY KEY (paintingID)
);

INSERT INTO painting  (artist, name, paintingyear )
VALUES 
   ('Leonardo Da Vinci', 'Mona Lisa', 1503), 
   ('Vincent van Gogh', 'The Starry Night', 1889);