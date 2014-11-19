-- ======================================================================
-- ===   Sql Script for Database : PostgreSQL db
-- ===
-- === 
-- Generated by:   Select Database Schema File Generator
-- Model:          \\Enabler\srv-win-utv-02\Prosjekter\Biovigelans\0               
-- Filename:       Z:\prosjekter\hemovgilans\db\meldingmelder.sql                  

-- Mapping:        Default                                                         
-- Date:           17 September 2014
-- ======================================================================

CREATE TABLE Melder
(
    helseregion          TEXT                NULL,
    helseforetak         TEXT                NULL,
    sykehus              TEXT                NULL,
    meldernavn           TEXT                NULL,
    melderepost          TEXT                NULL,
    meldertlf            TEXT                NULL,
    melderid             serial             ,
    PRIMARY KEY ( melderid )
);

CREATE TABLE Giver
  (
    giverId                          serial,
    kjonn                            varchar(2),
    alder                            varchar(10),
    vekt                             int4,
    givererfaring                    text,
    tidligerekomplikasjonjanei       text,
    tidligerekomplikasjonforklaring  text,
    givererfaringaferese             text,

    primary key(giverId)
  );

-- ======================================================================

CREATE TABLE Donasjon
  (
    donasjonsid               serial,
    donasjonssted             text,
    komplisertvenepunksjon    text,
    tappetype                 text,
    tappevarighet             text,
    lokalisasjonvenepunksjon  text,
    maltidfortapping          text,
    giverId                   int,

    primary key(donasjonsid),

    foreign key(giverId) references Giver(giverId) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Pasient
  (
    pasient_id        serial,
    kjonn             varchar(2),
    aldersGruppe      varchar(10),
    inneliggendePoli  varchar(8),
    avdeling          text,

    primary key(pasient_id)
  );

-- ======================================================================

CREATE TABLE Antistoff
  (
    antistoffId           serial,
    antistoffKode         text,
    antistoffbeskrivelse  text,
    pasient_id            int,

    primary key(antistoffId),

    foreign key(pasient_id) references Pasient(pasient_id) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Transfusjon
  (
    transfusjonsid           serial,
    transfusjondato          timestamptz,
    transfusjonsklokkeslett  time,
    hastegrad                text,
    feiltranfudert           text,
    indikasjon               text,
    antallenheter            int2,
    tidligerkomplikasjon	 text,
    pasient_id               int,

    primary key(transfusjonsid),

    foreign key(pasient_id) references Pasient(pasient_id) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Vigilansmelding
  (
    meldeid                   serial,
    datoforhendelse           timestamptz,
    klokkesletthendelse       time,
    datooppdaget              timestamptz,
    donasjonoverforing        timestamptz,
    sjekklistesaksbehandling  text,
    supplerendeopplysninger   text,
    meldingsdato              timestamptz,
    meldingsnokkel            TEXT                NULL,
        -- Dette flagget sier om meldingen er en kladd
    kladd                VARCHAR (3)         NULL,
    -- Dette flagget sier om meldinger er godkjent fra kvittering
    godkjent             VARCHAR (3)         NULL,
    -- Dato melding ble endret. Bare mulig dersom melding er lagret som kladd eller ikke godkjent.  
    endringsdato         timestamptz                NULL,
    melderid                  int,
    primary key(meldeid),
    foreign key( melderid) references Melder( melderid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Blodprodukt
  (
    blodProduktId    serial,
    blodtype         text,
    alderprodukt     timestamptz,
    tappetype        text,
    blodprodukt      text,
    produktegenskap  text,
    antalenheter     int2,
    transfusjonsId   int,
  -- antall enheter i en pakke (Akutt transfusjon)
    antallenheterpakke   INT             NULL,
    -- Suspensjonsmedium (tappetype aferese)
    suspensjon           TEXT                NULL,
        -- Antall trombocyttkonsentrater
    antalltromb          INT             NULL,
    -- Antall plasamaenheter
    antallplasma         INT             NULL,
    primary key(blodProduktId),

    foreign key(transfusjonsId) references Transfusjon(transfusjonsid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Giverkomplikasjon
  (
    stedforkomplikasjon                text,
    behandlingssted                    text,
    tidfrarapporteringtilkomplikasjon  text,
    tilleggsopplysninger               text,
    alvorlighetsgrad                   text,
    kliniskresultat                    text,
    varighetkomplikasjon               text,
    donasjonsid                        int,
    meldeid                            int,

    primary key(meldeid),

    foreign key(donasjonsid) references Donasjon(donasjonsid) match FULL on delete CASCADE,
    foreign key(meldeid) references Vigilansmelding(meldeid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Giveroppfolging
  (
    giveroppfolgingid              serial,
    klassifikasjongiveroppfolging  text,
    giveroppfolgingbeskrivelse     text,
    avregistrering                 text,
    meldeid                        int,

    primary key(giveroppfolgingid),

    foreign key(meldeid) references Giverkomplikasjon(meldeid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Komplikasjonsdiagnosegiver
  (
    komplikasjonsdiagnoseId   serial,
    lokalskadearm             text,
    systemiskbivirkning       text,
    annenreaksjon             text,
    lokalskadebeskrivelse     text,
    bivirkningbeskrivelse     text,
    annenreaksjonbeskrivelse  text,
    kommentar                 text,
    meldeid                   int,

    primary key(komplikasjonsdiagnoseId),

    foreign key(meldeid) references Giverkomplikasjon(meldeid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Sykdom
  (
    sykdomnavn    text,
    symptomer     text,
    diagnosekode  text,
    sykdomId      serial,
    pasient_id    int,

    primary key(sykdomId),

    foreign key(pasient_id) references Pasient(pasient_id) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Pasientkomplikasjon
  (
    klassifikasjon                           text,
    meldeid                                  int,
    transfusjonsid                           int,
    tidfrapabegynttrasfusjontilkomplikasjon  text,
    alvorlighetsgrad                         text,
    kliniskresultat                          text,
    arsakssammenheng                         text,

    primary key(meldeid),

    foreign key(meldeid) references Vigilansmelding(meldeid) on delete SET NULL,
    foreign key(transfusjonsid) references Transfusjon(transfusjonsid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Symptomer
  (
    symptomId              serial,
    symptomklassifikasjon  text,
    symptombeskrivelse     text,
    
      -- Temperatur angitt før temperaturstigning
    tempfor              NUMERIC (4,2)       NULL,
    -- Temperatur angitt etter temperaturstigning
    tempetter            NUMERIC (4,2)       NULL,
    meldeid                int,
     primary key(symptomId),
    foreign key(meldeid) references Pasientkomplikasjon(meldeid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Utredning
  (
    utredningId               serial,
    utredningsklassifikasjon  text,
    utredningbeskrivelse      text,
    blodtypeserologisk        text,
    hemolyseparameter         text,
    lga                       text,
    posedyrking               text,
    posedyrkingpositiv        text,
    meldeid                   int,

    primary key(utredningId),

    foreign key(meldeid) references Pasientkomplikasjon(meldeid) on delete CASCADE
  );

-- ======================================================================

CREATE TABLE Komplikasjonsklassifikasjon
  (
    klassifikasjonsid           serial,
    klassifikasjon              text,
    klassifikasjonsbeskrivelse  text,
    meldeid                     int,

    primary key(klassifikasjonsid),

    foreign key(meldeid) references Pasientkomplikasjon(meldeid) on delete CASCADE
  );

CREATE TABLE Hemolyse
(
    hemolyseparameter    TEXT                NULL,
    hemolysekode         TEXT                NULL,
    hemolyseid           SERIAL             NOT NULL,
    utredningId          int           NOT NULL,
    PRIMARY KEY ( hemolyseid )
);



ALTER TABLE Hemolyse
    ADD CONSTRAINT utredninghemolyse FOREIGN KEY ( utredningId ) REFERENCES Utredning ( utredningId );


CREATE TABLE Produktegenskap
(
    egenskapkode         TEXT                NULL,
    egenskapbeskrivelse  TEXT                NULL,
    produktegenskapId    SERIAL              NOT NULL,
    blodProduktId        INT            NOT NULL,
    PRIMARY KEY ( produktegenskapId )
);



ALTER TABLE Produktegenskap
    ADD CONSTRAINT blodproduktegenskap FOREIGN KEY ( blodProduktId ) REFERENCES Blodprodukt ( blodProduktId );

    

CREATE TABLE Annenkomplikasjon
(
    meldeid              INT           NOT NULL,
    -- Klassifikasjon av hendelsen (beskrivelse)
    klassifikasjon       TEXT                NULL,
    -- Klassifikasjonskode
    Klassifikasjonkode   TEXT                NULL,
    -- Beskrivelse av hendelsen
    komplikasjonbeskrivelse TEXT             NULL,
    -- Hva slags hendelse er dette?  
    komplikasjondefinisjon TEXT              NULL,
    -- Årsak til avviket
    avvikarsak           TEXT                NULL,
    -- Under hvilken prosess skjedde hendelsen?
    hovedprosess         TEXT                NULL,
    -- Gjennomførte eller planlagte tiltak
    tiltak               TEXT                NULL,
    -- Kommentarer til hendelsen
    kommentar            TEXT                NULL,
    -- Hvordan ble hendelsen oppdaget
    oppdaget             TEXT                NULL,
    PRIMARY KEY ( meldeid )
);



/*
Inneholder diskusjonen knyttet til en melding, og som pågår mellom melder og Mottaker/vurderer
*/
CREATE TABLE Diskusjon
(
    datoforkommentar     timestamptz            NULL,
    kommentar            TEXT                NULL,
    diskusjonid          SERIAL             NOT NULL,
    meldeid              INT           NOT NULL,
    PRIMARY KEY ( diskusjonid )
);


ALTER TABLE Annenkomplikasjon
    ADD CONSTRAINT annenmeldingtilmelding FOREIGN KEY ( meldeid ) REFERENCES Vigilansmelding ( meldeid );

ALTER TABLE Diskusjon
    ADD CONSTRAINT diskusjontilmelding FOREIGN KEY ( meldeid ) REFERENCES Vigilansmelding ( meldeid );
    
-- ======================================================================

