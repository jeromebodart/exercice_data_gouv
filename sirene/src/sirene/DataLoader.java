package sirene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataLoader {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/SIRENE";
			String user = "postgres";
			String passwd = "azerty";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			conn.setAutoCommit(false);
//			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//			-- SELECT oid, *  FROM sirene ORDER BY oid  LIMIT 5 ;
			//			-- oid start at 25470
			long OID_sirene = 25470;
			//			-- SELECT oid, *  FROM sirene_only_updates ORDER BY oid  LIMIT 5 ;
			//			-- oid start at 11391156
			long OID_sirene_only_updates=11391156;
			//			-- SELECT oid, *  FROM sirene ORDER BY oid  DESC LIMIT 5 ;
			//			-- oid end  at 25470
			long max_OID_sirene = 11390112;
			//			-- SELECT oid, *  FROM sirene_only_updates ORDER BY oid  DESC LIMIT 5 ;
			//			-- oid end  at 25470
			long max_OID_sirene_only_updates = 11390112;
			//			SELECT COUNT(*)  FROM SIRENE;
			//			result : 11364643
			//			We wheck that 11390112-25470 + 1 = 11364643 OK!!
			//			 11364643 = 10000.0 * 1136 + 4643.0                                                                                            
//			long n=OID;
			long id=1;
//			Preparation des statement pour les tables périphériques
			String query_info_siege="INSERT INTO info_siege (nic, code_region, departement_commune, email)\r\n" + 
					"SELECT DISTINCT NICSIEGE, RPEN, DEPCOMEN, ADR_MAIL\r\n" + 
					"FROM sirene_only_updates\r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_info_siege= conn.prepareStatement(query_info_siege);
			String query_identification_entreprise = "INSERT INTO identification_entreprise (raison_sociale, sigle, nom, prenom, civilite, repertoire_national_associations)\r\n" + 
					"SELECT DISTINCT NOMEN_LONG, SIGLE, NOM, PRENOM, CIVILITE, RNA\r\n" + 
					"FROM sirene_only_updates\r\n" + 
					"WHERE \r\n" + 
					"oid=oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_identification_entreprise = conn.prepareStatement(query_identification_entreprise);
			String query_caracteristiques_economiques_entreprise = "INSERT INTO caracteristiques_economiques_entreprise (nature_juridique, lib_nature_juridique, activite_principale, lib_activite_principale, annee_validite_activite_principale, activite_principale_registre_metier) \r\n" + 
					"SELECT DISTINCT nj, libnj, apen700, libapen, dapen, aprm\r\n" + 
					"FROM sirene_only_updates\r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_caracteristiques_economiques_entreprise = conn.prepareStatement(query_caracteristiques_economiques_entreprise);
			String query_adresse_declaree="INSERT INTO adresse_declaree (l1_declaree, l2_declaree, l3_declaree, l4_declaree, l5_declaree, l6_declaree, l7_declaree)\r\n" + 
					"SELECT DISTINCT l1_declaree, l2_declaree, l3_declaree, l4_declaree, l5_declaree, l6_declaree, l7_declaree\r\n" + 
					"FROM sirene_only_updates \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_adresse_declaree = conn.prepareStatement(query_adresse_declaree);
			String query_adresse_normalisee="INSERT INTO adresse_normalisee (l1_normalisee, l2_normalisee, l3_normalisee, l4_normalisee, l5_normalisee, l6_normalisee, l7_normalisee)\r\n" + 
					"SELECT DISTINCT l1_normalisee, l2_normalisee, l3_normalisee, l4_normalisee, l5_normalisee, l6_normalisee, l7_normalisee\r\n" + 
					"FROM sirene_only_updates \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_adresse_normalisee = conn.prepareStatement(query_adresse_normalisee);
			String query_informations_etablissement="INSERT INTO informations_etablissement (enseigne, ind_publipo, siege, statut_diffusion, date_diffusion_base)\r\n" + 
					"SELECT DISTINCT enseigne, ind_publipo, siege, diffcom, amintret\r\n" + 
					"FROM sirene_only_updates \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_informations_etablissement = conn.prepareStatement(query_informations_etablissement);
			String query_adresse_geographique="INSERT INTO adresse_geographique (numvoie, indrep, typvoie, libvoie, codpos, cedex)\r\n" + 
					"SELECT DISTINCT numvoie, indrep, typvoie, libvoie, codpos, cedex\r\n" + 
					"FROM sirene_only_updates \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_adresse_geographique= conn.prepareStatement(query_adresse_geographique);
			String query_localisation_geographique="INSERT INTO localisation_geographique (region, lib_region, departement, arrondissement, canton, commune, lib_commune, departement_unite_urbaine, taille_unite_urbaine, num_unite_urbaine, epci, tcd, zemet)\r\n" + 
					"SELECT DISTINCT RPET, LIBREG, DEPET, ARRONET, CTONET, COMET, LIBCOM, DU, TU, UU, EPCI, TCD, ZEMET\r\n" + 
					"FROM sirene_only_updates \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_localisation_geographique= conn.prepareStatement(query_localisation_geographique);
			String query_caracteristiques_economiques_etablissement="INSERT INTO caracteristiques_economiques_etablissement (nature, lib_nature, activite_principale, lib_activite_principale)\r\n" + 
					"SELECT DISTINCT NATETAB, LIBNATETAB, APET700, LIBAPET\r\n" + 
					"FROM sirene_only_updates \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_caracteristiques_economiques_etablissement= conn.prepareStatement(query_caracteristiques_economiques_etablissement);
			String query_updates="INSERT INTO updates (nature_update ,modification_activite_etablissement, modification_nature_etablissement, modification_entreprisedate)\r\n" + 
					"SELECT DISTINCT VMAJ, VMAJ1, VMAJ2, VMAJ3, DATEMAJ\r\n" + 
					"FROM sirene \r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_updates= conn.prepareStatement(query_updates);
//			Here we can now create every peripheric tables
			Complete_table(prepare_info_siege, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_identification_entreprise, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_caracteristiques_economiques_entreprise, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_adresse_declaree, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_adresse_normalisee, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_informations_etablissement, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_adresse_geographique, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_localisation_geographique, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_caracteristiques_economiques_etablissement, OID_sirene_only_updates, max_OID_sirene_only_updates);
			Complete_table(prepare_updates, OID_sirene, max_OID_sirene);
//			Fermeture des prepared Statements
			prepare_info_siege.close();
			prepare_identification_entreprise.close();
			prepare_caracteristiques_economiques_entreprise.close();
			prepare_adresse_declaree.close();
			prepare_adresse_normalisee.close();
			prepare_informations_etablissement.close();
			prepare_adresse_geographique.close();
			prepare_localisation_geographique.close();
			prepare_caracteristiques_economiques_etablissement.close();
			prepare_updates.close();
//			Constuttion de la table entreprise
			String query_entreprise="INSERT INTO entreprise (siren, id_siege, id_identification_entreprise, id_caracteristiques)\r\n" + 
					"SELECT ENTREPRISES.siren, ENTREPRISES.INFO, ENTREPRISES.IDENT, ENTREPRISES.CARAC\r\n" + 
					"FROM\r\n" + 
					"(SELECT DISTINCT sirene_only_updates.siren,\r\n" + 
					"(SELECT id FROM info_siege WHERE info_siege.nic=sirene_only_updates.nicsiege  AND info_siege.code_region=sirene_only_updates.rpen AND info_siege.departement_commune=sirene_only_updates.depcomen AND info_siege.email=sirene_only_updates.adr_mail)::integer AS INFO,\r\n" + 
					"(SELECT id FROM identification_entreprise WHERE identification_entreprise.raison_sociale=sirene_only_updates.nomen_long AND identification_entreprise.sigle=sirene_only_updates.sigle AND identification_entreprise.nom=sirene_only_updates.nom AND identification_entreprise.prenom=sirene_only_updates.prenom\r\n" + 
					"AND identification_entreprise.civilite=sirene_only_updates.civilite AND identification_entreprise.repertoire_national_associations=sirene_only_updates.rna)::integer AS IDENT,\r\n" + 
					"(SELECT id FROM caracteristiques_economiques_entreprise WHERE \r\n" + 
					"caracteristiques_economiques_entreprise.nature_juridique=sirene_only_updates.nj AND\r\n" + 
					"caracteristiques_economiques_entreprise.lib_nature_juridique=sirene_only_updates.libnj AND\r\n" + 
					"caracteristiques_economiques_entreprise.activite_principale=sirene_only_updates.apen700 AND \r\n" + 
					"caracteristiques_economiques_entreprise.lib_activite_principale=sirene_only_updates.libapen AND\r\n" + 
					"caracteristiques_economiques_entreprise.annee_validite_activite_principale=sirene_only_updates.dapen AND\r\n" + 
					"caracteristiques_economiques_entreprise.activite_principale_registre_metier=sirene_only_updates.aprm)::integer AS CARAC\r\n" + 
					"FROM sirene_only_updates\r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? \r\n" + 
					"GROUP BY sirene_only_updates.siren, INFO, IDENT, CARAC) AS ENTREPRISES;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_entreprise= conn.prepareStatement(query_entreprise);
			Complete_table(prepare_entreprise, OID_sirene_only_updates, max_OID_sirene_only_updates);
			prepare_entreprise.close();
			String query_etablissement="INSERT INTO etablissement (SIRET, id_entreprise , nic, id_adresse_normalisee, id_adresse_normalisee, id_info, id_adresse_geographique, id_localisation_geographique, id_caracteristiques_economiques)\r\n" + 
					"SELECT ETABLISSEMENT.SIRET, ETABLISSEMENT.SIREN, ETABLISSEMENT.NIC, ETABLISSEMENT.ADRDCL, ETABLISSEMENT.ADRNORM, ETABLISSEMENT.INFO, ETABLISSEMENT.ADRGEO, ETABLISSEMENT.LOCGEO, ETABLISSEMENT.CARACECO\r\n" + 
					"FROM\r\n" + 
					"(SELECT DISTINCT sirene_only_updates.siret AS SIRET,\r\n" + 
					"(SELECT DISTINCT siren FROM entreprise WHERE entreprise.siren=sirene_only_updates.siren)::varchar AS SIREN,\r\n" + 
					"SELECT DISTINCT nic FROM sirene_only_updates AS SIREN,\r\n" + 
					"(SELECT id FROM adresse_normalisee WHERE adresse_normalisee.l1_normalisee=sirene_only_updates.l1_normalisee AND \r\n" + 
					"adresse_normalisee.l2_normalisee=sirene_only_updates.l2_normalisee AND\r\n" + 
					"adresse_normalisee.l3_normalisee=sirene_only_updates.l3_normalisee AND\r\n" + 
					"adresse_normalisee.l4_normalisee=sirene_only_updates.l4_normalisee AND\r\n" + 
					"adresse_normalisee.l5_normalisee=sirene_only_updates.l5_normalisee AND\r\n" + 
					"adresse_normalisee.l6_normalisee=sirene_only_updates.l6_normalisee AND\r\n" + 
					"adresse_normalisee.l7_normalisee=sirene_only_updates.l7_normalisee)::integer AS ADRDCL,\r\n" + 
					"(SELECT id FROM adresse_normalisee WHERE adresse_normalisee.l1_normalisee=sirene_only_updates.l1_normalisee AND \r\n" + 
					"adresse_normalisee.l2_normalisee=sirene_only_updates.l2_normalisee AND\r\n" + 
					"adresse_normalisee.l3_normalisee=sirene_only_updates.l3_normalisee AND\r\n" + 
					"adresse_normalisee.l4_normalisee=sirene_only_updates.l4_normalisee AND\r\n" + 
					"adresse_normalisee.l5_normalisee=sirene_only_updates.l5_normalisee AND\r\n" + 
					"adresse_normalisee.l6_normalisee=sirene_only_updates.l6_normalisee AND\r\n" + 
					"adresse_normalisee.l7_normalisee=sirene_only_updates.l7_normalisee)::integer AS ADRNORM,\r\n" + 
					"(SELECT DISTINCT id FROM informations_etablissement \r\n" + 
					"WHERE \r\n" + 
					"informations_etablissement.enseigne=sirene_only_updates.enseigne AND \r\n" + 
					"informations_etablissement.siege=sirene_only_updates.siege AND \r\n" + 
					"informations_etablissement.ind_publipo=sirene_only_updates.ind_publipo AND \r\n" + 
					"informations_etablissement.statut_diffusion=sirene_only_updates.diffcom AND \r\n" + 
					"informations_etablissement.date_diffusion_base=sirene_only_updates.amintret)::integer AS INFO,\r\n" + 
					"(SELECT DISTINCT id FROM adresse_geographique \r\n" + 
					"WHERE \r\n" + 
					"adresse_geographique.numvoie=sirene_only_updates.numvoie AND \r\n" + 
					"adresse_geographique.indrep=sirene_only_updates.indrep AND \r\n" + 
					"adresse_geographique.typvoie=sirene_only_updates.typvoie AND \r\n" + 
					"adresse_geographique.libvoie=sirene_only_updates.libvoie AND\r\n" + 
					"adresse_geographique.codpos=sirene_only_updates.codpos AND \r\n" + 
					"adresse_geographique.cedex=sirene_only_updates.cedex)::integer AS ADRGEO,\r\n" + 
					"(SELECT DISTINCT id FROM localisation_geographique \r\n" + 
					"WHERE \r\n" + 
					"localisation_geographique.region=sirene_only_updates.RPET AND \r\n" + 
					"localisation_geographique.lib_region=sirene_only_updates.LIBREG AND \r\n" + 
					"localisation_geographique.departement=sirene_only_updates.DEPET AND \r\n" + 
					"localisation_geographique.arrondissement=sirene_only_updates.ARRONET AND\r\n" + 
					"localisation_geographique.canton=sirene_only_updates.CTONET AND \r\n" + 
					"localisation_geographique.commune=sirene_only_updates.COMET AND\r\n" + 
					"localisation_geographique.lib_commune=sirene_only_updates.LIBCOM AND  \r\n" + 
					"localisation_geographique.departement_unite_urbaine=sirene_only_updates.DU AND \r\n" + 
					"localisation_geographique.taille_unite_urbaine=sirene_only_updates.TU AND \r\n" + 
					"localisation_geographique.num_unite_urbaine=sirene_only_updates.UU AND \r\n" + 
					"localisation_geographique.epci=sirene_only_updates.EPCI AND \r\n" + 
					"localisation_geographique.tcd=sirene_only_updates.TCD AND \r\n" + 
					"localisation_geographique.zemet=sirene_only_updates.ZEMET)::integer AS LOCGEO,\r\n" + 
					"(SELECT DISTINCT id FROM caracteristiques_economiques_etablissement \r\n" + 
					"WHERE \r\n" + 
					"caracteristiques_economiques_etablissement.nature=sirene_only_updates.NATETAB AND \r\n" + 
					"caracteristiques_economiques_etablissement.lib_nature=sirene_only_updates.LIBNATETAB AND \r\n" + 
					"caracteristiques_economiques_etablissement.activite_principale=sirene_only_updates.APET700 AND \r\n" + 
					"caracteristiques_economiques_etablissement.lib_activite_principale=sirene_only_updates.LIBAPET)::integer AS CARACECO,\r\n" + 
					"FROM sirene_only_updates\r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ?\r\n" + 
					"GROUP BY SIRET, SIREN, NIC, ADRDCL, ADRNORM, INFO, ADRGEO, LOCGEO, CARACECO) AS ETABLISSEMENT;\r\n" + 
					"";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_etablissement= conn.prepareStatement(query_etablissement);
			Complete_table(prepare_etablissement, OID_sirene_only_updates, max_OID_sirene_only_updates);
			prepare_etablissement.close();
			String query_etablissement_join_updates="INSERT INTO etablissement_join_updates (id_etablissement, id_updates)\r\n" + 
					"SELECT DISTINCT siret, UPDATES\r\n" + 
					"FROM\r\n" + 
					"(SELECT DISTINCT SIRET FROM etablissement),\r\n" + 
					"(SELECT DISTINCT id FROM updates \r\n" + 
					"WHERE \r\n" + 
					"updates.VMAJ=sirene.VMAJ AND\r\n" + 
					"updates.VMAJ1=sirene.VMAJ1 AND \r\n" + 
					"updates.VMAJ2= sirene.VMAJ2 AND \r\n" + 
					"updates.VMAJ3=sirene.VMAJ3 AND \r\n" + 
					"updates.DATEMAJ=sirene.DATEMAJ\r\n" + 
					")\r\n" + 
					"FROM sirene\r\n" + 
					"WHERE \r\n" + 
					"oid BETWEEN ? and ? ;";
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepare_etablissement_join_updates= conn.prepareStatement(query_etablissement_join_updates);
			Complete_table(prepare_etablissement_join_updates, OID_sirene, max_OID_sirene);
			prepare_etablissement_join_updates.close();
			conn.close();
			System.out.println("C fini!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void Complete_table(PreparedStatement prepare, long oID, long max_OID_sirene_only_updates) throws SQLException {
		// TODO Auto-generated method stub
		
		while(oID<11364643) {
			//				Intervalle of value [n, MATH.min(n + 1136, 11364643]
//			First value
			prepare.setLong(1, oID);
//			Second value
			prepare.setLong(2, (oID + 10000));
//			Executing query
			prepare.executeUpdate();
			oID=oID+10000;
		}
	}

}
