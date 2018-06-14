INSERT INTO theatre (name, row, col) VALUES
('Salong 1', '10','10'),
('Salong 2', '20', '20'),
('Salong 3', '30', '30'),
('Salong 4', '40', '40');

INSERT INTO movie (title, description) VALUES
('Harry Potter', 'Sim salabim'),
('The Terminator', 'Ill be back'),
('The Nun', 'Praise the Lord'),
('Hitta Nemo', 'Hohahaha');

INSERT INTO show (movie_id, theatre_id, start, stop) VALUES
(1,1,'2018-01-01 12:00:00', '2018-01-01 14:00:00'),
(2,2,'2018-01-01 12:00:00', '2018-01-01 14:00:00'),
(3,3,'2018-01-01 12:00:00', '2018-01-01 14:00:00'),
(4,4,'2018-01-01 12:00:00', '2018-01-01 14:00:00');

INSERT INTO customer (name, adress, phone_number) VALUES
('Joe Stalin', 'Kreml', '123-456'),
('Bubba Rosevelt', 'Pearl Harbor', '678-123');

INSERT INTO ticket (customer_id, show_id, seat_row, seat_col) VALUES
(1,1,1,1),
(2,2,1,1),
(1,2,1,2),
(1,3,1,1);
