use atletik;

INSERT INTO discipline (discipline_name, result_type) VALUES
                                                          ('1-milløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('10.000-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('100-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('110 meter hækkeløb', 'HH:MM:SS:SSS'),
                                                          ('1500-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('200 meter hækkeløb', 'HH:MM:SS:SSS'),
                                                          ('200-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('3000-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('4 × 100-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('4 × 400-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('400 meter hækkeløb', 'HH:MM:SS:SSS'),
                                                          ('400-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('4x400-meterløb blandet hold (atletik)', 'HH:MM:SS:SSS'),
                                                          ('5000-meter-løb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('60 meter hækkeløb', 'HH:MM:SS:SSS'),
                                                          ('60-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('800-meterløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('Cross (løbesport)', 'HH:MM:SS:SSS'),
                                                          ('Diskoskast (atletik)', 'length'),
                                                          ('Femkamp (atletik)', 'points'),
                                                          ('Forhindringsløb (atletik)', 'HH:MM:SS:SSS'),
                                                          ('Halvmaratonløb (løbesport)', 'HH:MM:SS:SSS'),
                                                          ('Hammerkast (atletik)', 'length'),
                                                          ('Højdespring (atletik)', 'length'),
                                                          ('Højdespring uden tilløb (atletik)', 'length'),
                                                          ('Kastefemkamp (atletik)', 'points'),
                                                          ('Kastetrekamp', 'points'),
                                                          ('Kuglestød (atletik)', 'length'),
                                                          ('Kørestolsrace', 'HH:MM:SS:SSS'),
                                                          ('Længdespring (atletik)', 'length'),
                                                          ('Længdespring uden tilløb (atletik)', 'length'),
                                                          ('Maratonløb (løbesport)', 'HH:MM:SS:SSS'),
                                                          ('Slyngboldkast (atletik)', 'length'),
                                                          ('Spydkast (atletik)', 'length'),
                                                          ('Stangspring (atletik)', 'length'),
                                                          ('Syvkamp (atletik)', 'points'),
                                                          ('Tikamp (atletik)', 'points'),
                                                          ('Tovtrækning', 'points'),
                                                          ('Trail (løbesport)', 'HH:MM:SS:SSS'),
                                                          ('Trespring (atletik)', 'length'),
                                                          ('Trespring uden tilløb (atletik)', 'length'),
                                                          ('Vægtkast (atletik)', 'length');



-- Participants with random names and associated disciplines
INSERT INTO participant (name, gender, age, club) VALUES
                                                      ('John Doe', 'Male', 25, 'AIK 95'),
                                                      ('Jane Smith', 'Female', 22, 'AK Delta Slagelse'),
                                                      ('Michael Johnson', 'Male', 28, 'AK-Holstebro'),
                                                      ('Emily Davis', 'Female', 24, 'Amager Atletik Club'),
                                                      ('David Brown', 'Male', 30, 'Atletikklubben af 1973'),
                                                      ('Sarah Miller', 'Female', 27, 'Bagsværd Atletik Club'),
                                                      ('Robert Wilson', 'Male', 26, 'Ballerup Atletik Klub'),
                                                      ('Jessica Lee', 'Female', 29, 'Esbjerg Atletik og Motion'),
                                                      ('William Taylor', 'Male', 23, 'FIF Hillerød'),
                                                      ('Olivia Moore', 'Female', 21, 'Frederiksberg Idræts-Forening'),
                                                      ('Daniel Clark', 'Male', 22, 'Glostrup Idræts Club - Atletik & Motion'),
                                                      ('Sophia Robinson', 'Female', 24, 'Hellas Roskilde'),
                                                      ('James Martinez', 'Male', 27, 'Hvidovre AM'),
                                                      ('Emma Harris', 'Female', 25, 'Idrætsforeningen Gullfoss'),
                                                      ('Alexander White', 'Male', 28, 'IK Viking Rønne Atletik og Motion'),
                                                      ('Ava Anderson', 'Female', 23, 'Københavns Idræts Forening'),
                                                      ('Matthew Thompson', 'Male', 26, 'Langgarverne (Hillerød Løbe- og Triatlonklub)'),
                                                      ('Mia Lewis', 'Female', 21, 'Odense Atletik/Odense Gymnastikforening'),
                                                      ('Ethan Walker', 'Male', 29, 'Randers Real AM'),
                                                      ('Isabella Hall', 'Female', 24, 'Skive AM'),
                                                      ('Joseph Green', 'Male', 30, 'Sparta Atletik'),
                                                      ('Amelia King', 'Female', 25, 'Trongårdens IF'),
                                                      ('Benjamin Young', 'Male', 23, 'Vejle Idrætsforening'),
                                                      ('Chloe Scott', 'Female', 28, 'Aarhus Fremad'),
                                                      ('Andrew Perez', 'Male', 27, 'Aalborg Fodsportsforening'),
                                                      ('Grace Baker', 'Female', 22, 'AIK 95'),
                                                      ('Lucas Turner', 'Male', 26, 'AK Delta Slagelse'),
                                                      ('Lily Reed', 'Female', 29, 'AK-Holstebro'),
                                                      ('Gabriel Hill', 'Male', 24, 'Amager Atletik Club'),
                                                      ('Zoe Ward', 'Female', 21, 'Atletikklubben af 1973'),
                                                      ('Xavier Brooks', 'Male', 25, 'Bagsværd Atletik Club'),
                                                      ('Madison Coleman', 'Female', 22, 'Ballerup Atletik Klub'),
                                                      ('Samuel Rivera', 'Male', 28, 'Esbjerg Atletik og Motion'),
                                                      ('Hannah Mitchell', 'Female', 24, 'FIF Hillerød'),
                                                      ('Logan Gray', 'Male', 30, 'Frederiksberg Idræts-Forening'),
                                                      ('Natalie Ward', 'Female', 27, 'Glostrup Idræts Club - Atletik & Motion'),
                                                      ('Jackson Torres', 'Male', 26, 'Hellas Roskilde'),
                                                      ('Victoria Adams', 'Female', 29, 'Hvidovre AM'),
                                                      ('Nicholas Carter', 'Male', 23, 'Idrætsforeningen Gullfoss'),
                                                      ('Ella Price', 'Female', 21, 'IK Viking Rønne Atletik og Motion'),
                                                      ('Christian Morris', 'Male', 22, 'Københavns Idræts Forening'),
                                                      ('Avery Rivera', 'Female', 24, 'Langgarverne (Hillerød Løbe- og Triatlonklub)'),
                                                      ('Samantha Evans', 'Male', 27, 'Odense Atletik/Odense Gymnastikforening'),
                                                      ('Ryan Cook', 'Female', 25, 'Randers Real AM'),
                                                      ('Sophie Butler', 'Male', 28, 'Skive AM'),
                                                      ('Dylan Nelson', 'Female', 23, 'Sparta Atletik'),
                                                      ('Claire Ward', 'Male', 26, 'Trongårdens IF'),
                                                      ('Luke Martinez', 'Female', 21, 'Vejle Idrætsforening'),
                                                      ('Leah Stewart', 'Male', 29, 'Aarhus Fremad'),
                                                      ('Elijah Phillips', 'Female', 24, 'Aalborg Fodsportsforening');

-- Participant discipline associations based on their IDs (adjust as needed)

INSERT INTO participant_discipline (participant_id, discipline_id) VALUES

                                                                       (1, 1), (1, 2), (1, 3),

                                                                       (2, 4), (2, 5), (2, 6),

                                                                       (3, 7), (3, 8),

                                                                       (4, 9), (4, 10), (4, 11),

                                                                       (5, 12), (5, 13),

                                                                       (6, 14), (6, 15),

                                                                       (7, 16), (7, 17),

                                                                       (8, 18), (8, 19),

                                                                       (9, 20), (9, 21),

                                                                       (10, 22), (10, 23),

                                                                       (11, 24), (11, 25),

                                                                       (12, 26), (12, 27),

                                                                       (13, 28), (13, 29),

                                                                       (14, 30), (14, 31),

                                                                       (15, 32), (15, 33),

                                                                       (16, 34), (16, 35),

                                                                       (17, 36), (17, 37),

                                                                       (18, 38), (18, 39),

                                                                       (19, 40), (19, 41),

                                                                       (20, 42),  (24, 1),

                                                                       (25, 2), (25, 3),

                                                                       (26, 4), (26, 5),

                                                                       (27, 6), (27, 7),

                                                                       (28, 8), (28, 9),

                                                                       (29, 10), (29, 11),

                                                                       (30, 12), (30, 13),

                                                                       (31, 14), (31, 15),

                                                                       (32, 16), (32, 17),

                                                                       (33, 18), (33, 19),

                                                                       (34, 20), (34, 21),

                                                                       (35, 22), (35, 23),

                                                                       (36, 24), (36, 25),

                                                                       (37, 26), (37, 27),

                                                                       (38, 28), (38, 29),

                                                                       (39, 30), (39, 31),

                                                                       (40, 32), (40, 33),

                                                                       (41, 34), (41, 35),

                                                                       (42, 36), (42, 37),

                                                                       (43, 38), (43, 39),

                                                                       (44, 40), (44, 41),

                                                                       (45, 42), (49, 1),

                                                                       (50, 2), (50, 3);

-- Insert statements for results table
INSERT INTO result (participant_id, discipline_id, result_value)
SELECT
    p.id AS participant_id,
    d.id AS discipline_id,
    CASE
        WHEN d.result_type = 'points' THEN CONCAT(FLOOR(RAND() * 1000), ' points')
        WHEN d.result_type = 'length' THEN CONCAT(FLOOR(RAND() * 100), ' meters')
        WHEN d.result_type = 'HH:MM:SS:SSS' THEN CONCAT(FLOOR(RAND() * 10), ':', FLOOR(RAND() * 60), ':', FLOOR(RAND() * 60), '.', FLOOR(RAND() * 1000))
        ELSE NULL -- Handle other cases if necessary
        END AS result_value
FROM
    discipline d
        CROSS JOIN participant p
WHERE
    d.result_type IN ('points', 'length', 'HH:MM:SS:SSS')
ORDER BY
    RAND()
    LIMIT 300;


