-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA IF EXISTS calendrify CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA calendrify
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA calendrify TO postgres;
GRANT ALL ON SCHEMA calendrify TO PUBLIC;