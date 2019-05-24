DELETE
FROM author;
DELETE
FROM book;
DELETE
FROM authorbooks;

INSERT INTO author (authorid, firstname, lastname) VALUES (1, 'John', 'Mitchell');
INSERT INTO author (authorid, firstname, lastname) VALUES (2, 'Dan', 'Brown');
INSERT INTO author (authorid, firstname, lastname) VALUES (3, 'Jerry', 'Poe');
INSERT INTO author (authorid, firstname, lastname) VALUES (4, 'Wells', 'Teague');
INSERT INTO author (authorid, firstname, lastname) VALUES (5, 'George', 'Gallinger');
INSERT INTO author (authorid, firstname, lastname) VALUES (6, 'Ian', 'Stewart');

INSERT INTO book (bookid, booktitle, ISBN, copyyear) VALUES (1, 'Flatterland', '9780738206752', 2001);
INSERT INTO book (bookid, booktitle, ISBN, copyyear) VALUES (2, 'Digital Fortess', '9788489367012', 2007);
INSERT INTO book (bookid, booktitle, ISBN, copyyear) VALUES (3, 'The Da Vinci Code', '9780307474278', 2009);
INSERT INTO book (bookid, booktitle, ISBN, copyyear) VALUES (4, 'Essentials of Finance', '1314241651234', 1998);
INSERT INTO book (bookid, booktitle, ISBN, copyyear) VALUES (5, 'Calling Texas Home', '1885171382134', 2000);

INSERT INTO authorbooks (bookid, authorid) VALUES (1, 1);
INSERT INTO authorbooks (bookid, authorid) VALUES (1, 2);
INSERT INTO authorbooks (bookid, authorid) VALUES (2, 2);

-- alter sequence hibernate_sequence restart with 25;
