# exercice_data_gouv_model_creation_and_migration

Create an application and exploit record of all companies and their building in France (SIREN, SIRET)
[end of the 30d of april 2019] 

+-2weeks project

This work is a training to :
- think and create a sql model
- migrate, filter and exploit large data (+11 millions lines)

The database choosed for this work can be found at : 
 "BDD" : https://www.data.gouv.fr/fr/datasets/base-sirene-des-entreprises-et-de-leurs-etablissements-siren-siret-fin-le-30-avril-2019/#_
 "Documentation" : https://api.insee.fr/catalogue/site/themes/wso2/subthemes/insee/pages/item-info.jag?name=Sirene&version=V3&provider=insee

The work has been done step by step:

1) Create model following documentation (LISTE8YTABLE.pdf) ==> Schema.png 

2) Created Beans from model and then Test.java to check beans and capacity to create instance from each row of the database

3) Create model (file "creation_schema.txt")

4) Created LineSpliter.java to split excel database in WIN1252 format to several csv files in UTF-8 and inject the database in postgres to explore the datas and enhance the robustness
of the model.

5) Created CreationSireneUpdateOnlyApplication in a SpringBootApp to create a new database called sirene_only_update (script in "sirene_only_updates.txt") with : 
- A column SIRET
- Only last updates (exploit timestamp in last column)

==> Insertt the first 400 002 lines only

6) Transfer data (except concerning updates) from the new database to the model using SQL in postgres 
==>("script_insertion_donnees.txt")
Not need because no updates found in the first 400 002 lines

7) Execute java to transfer all the data
==> DataLoader.java
*String querries have to be updated 
8) For each establishment add updates than have been made using the former database
