package bd;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONException;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDB extends Utils {

	String usuario = "martinelsalvador";
	String psw = "12345";
	String uri = "mongodb+srv://martinelsalvador:12345@basedatosii.2bqbi.mongodb.net/?retryWrites=true&w=majority";
	String db = "Dinamax";
	
	public boolean verificarAdministrador(String usuario, String psw) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection("Administrador");
	        Document doc = collection.find(eq("usuario", "boss")).first();
	        String json = doc.toJson();
	        
	        String _usuario = readString("usuario", json);
	        String _psw = readString("psw", json);
	        
	        if (usuario.equals(_usuario) && psw.equals(_psw))
	        	return true;
	        else
	        	return false;
	    }
	}
	
	public void addProyecto(Proyecto proyecto) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("Proyectos");
		        
		        String nombre_proyecto = proyecto.get_nombre_proyecto();
		        String rut = proyecto.get_rut();
		        
		        // Object "nombre"
		        String nombre = proyecto.get_nombre().get_nombre();
		        String apellido1 = proyecto.get_nombre().get_apellido1();
		        String apellido2 = proyecto.get_nombre().get_apellido2();
		        
		        // Object "direccion"
		        String calle = proyecto.get_direccion().get_calle();
		        String numero = proyecto.get_direccion().get_numero();
		        String CCP = proyecto.get_direccion().get_CCP();
		        
		        String subsidio  = proyecto.get_subsidio();
		        String monto_subsidio = proyecto.get_monto_subsidio();
		        String presupuesto = proyecto.get_presupuesto();
		        String duracion_obra = proyecto.get_duracion_obra();
		        
		        // Object "fecha_inicio"
		        String dia = proyecto.get_fecha_inicio().get_dia();
		        String mes = proyecto.get_fecha_inicio().get_mes();
		        String ano = proyecto.get_fecha_inicio().get_ano();
		        
		        String estado_obra = proyecto.get_estado_obra();
		        
		        // Object "materiales_usados" <dynamic>
		        ArrayList<String> materiales_usados = proyecto.get_materiales_usados();
		        
		        // Object "registro" <dynamic>
		        ArrayList<String> registro = proyecto.get_registro();
		        
		        Document doc = new Document()
		       		 .append("nombre_proyecto", nombre_proyecto)
		       		 .append("rut", rut)
		       		 /*.append("nombre", new Document()
		       				 .append("0", nombre)
		       				 .append("1", apellido1)
		       				 .append("2", apellido2))*/
		       		 .append("nombre", Arrays.asList(nombre, apellido1, apellido2))
		       		 /*.append("Direccion", new Document()
		       				 .append("0", calle)
		       				 .append("1", numero)
		       				 .append("2", CCP))*/
		       		 .append("Direccion", Arrays.asList(calle, numero, CCP))
		       		 .append("subsidio", subsidio)
		       		 .append("monto_subsidio", monto_subsidio)
		       		 .append("presupuesto", presupuesto)
		       		 .append("duracion_obra", duracion_obra)
		       		 /*.append("fecha_inicio", new Document()
		       				 .append("0", dia)
		       				 .append("1", mes)
		       				 .append("2", ano))*/
		       		 .append("fecha_inicio", Arrays.asList(dia, mes, ano))
		       		 .append("estado_obra", estado_obra)
		       		 .append("materiales_usados", materiales_usados)
		       		 .append("registro", registro);
		       		 
		        collection.insertOne(doc);
		}
	}
	
	public void updtProyecto(String _id, Proyecto proyecto) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("Proyectos");
		        
		        //String id = proyecto.get__id();
		        String nombre_proyecto = proyecto.get_nombre_proyecto();
		        String rut = proyecto.get_rut();
		        
		        // Object "nombre"
		        String nombre = proyecto.get_nombre().get_nombre();
		        String apellido1 = proyecto.get_nombre().get_apellido1();
		        String apellido2 = proyecto.get_nombre().get_apellido2();
		        
		        // Object "direccion"
		        String calle = proyecto.get_direccion().get_calle();
		        String numero = proyecto.get_direccion().get_numero();
		        String CCP = proyecto.get_direccion().get_CCP();
		        
		        String subsidio  = proyecto.get_subsidio();
		        String monto_subsidio = proyecto.get_monto_subsidio();
		        String presupuesto = proyecto.get_presupuesto();
		        String duracion_obra = proyecto.get_duracion_obra();
		        
		        // Object "fecha_inicio"
		        String dia = proyecto.get_fecha_inicio().get_dia();
		        String mes = proyecto.get_fecha_inicio().get_mes();
		        String ano = proyecto.get_fecha_inicio().get_ano();
		        
		        String estado_obra = proyecto.get_estado_obra();
		        
		        // Object "materiales_usados" <dynamic>
		        ArrayList<String> materiales_usados = proyecto.get_materiales_usados();
		        
		        // Object "registro" <dynamic>
		        ArrayList<String> registro = proyecto.get_registro();
		        
		        Document replaceDocument = new Document()
		       		 //.append("_id", new ObjectId(id))
		       		 .append("nombre_proyecto", nombre_proyecto)
		       		 .append("rut", rut)
		       		 /*.append("nombre", new Document()
		       				 .append("0", nombre)
		       				 .append("1", apellido1)
		       				 .append("2", apellido2))*/
		       		 .append("nombre", Arrays.asList(nombre, apellido1, apellido2))
		       		 /*.append("Direccion", new Document()
		       				 .append("0", calle)
		       				 .append("1", numero)
		       				 .append("2", CCP))*/
		       		 .append("Direccion", Arrays.asList(calle, numero, CCP))
		       		 .append("subsidio", subsidio)
		       		 .append("monto_subsidio", monto_subsidio)
		       		 .append("presupuesto", presupuesto)
		       		 .append("duracion_obra", duracion_obra)
		       		 /*.append("fecha_inicio", new Document()
		       				 .append("0", dia)
		       				 .append("1", mes)
		       				 .append("2", ano))*/
		       		 .append("fecha_inicio", Arrays.asList(dia, mes, ano))
		       		 .append("estado_obra", estado_obra)
		       		 .append("materiales_usados", materiales_usados)
		       		 .append("registro", registro);
		        
		        collection.replaceOne(Filters.eq("_id", new ObjectId(_id)), replaceDocument);
		        
		}
	}
	
	public void delProyecto(String _id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("Proyectos");
		        
		        Bson query = eq("_id", new ObjectId(_id));
		        try {
		       	 collection.deleteOne(query);
		        } catch (MongoException me) {
		       	 // Do nothing
		        }
		}
	}
	
	public Proyecto getProyecto(String _id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection("Proyectos");
	        Document doc = collection.find(eq("_id", new ObjectId(_id))).first();
	        String json = doc.toJson();
	        
	        String _nombre_proyecto = readString("nombre_proyecto", json);
	        String rut = readString("rut", json);
	        Nombre nombre;
	        String _nombre = readStringInArray("nombre", 0, json);
	        String apellido1 = readStringInArray("nombre", 1, json);
	        String apellido2 = readStringInArray("nombre", 2, json);
	        nombre = new Nombre(_nombre, apellido1, apellido2);
	        Direccion direccion;
	        String calle = readStringInArray("Direccion", 0, json);
	        String numero = readStringInArray("Direccion", 1, json);
	        String CCP = readStringInArray("Direccion", 2, json);
	        direccion = new Direccion(calle, numero, CCP);
	        String subsidio = readString("subsidio", json);
	        String monto_subsidio = readString("monto_subsidio", json);
	        String presupuesto = readString("presupuesto", json);
	        String duracion_obra = readString("duracion_obra", json);
	        Fecha_inicio fecha_inicio;
	        String dia = readStringInArray("fecha_inicio", 0, json);
	        String mes = readStringInArray("fecha_inicio", 1, json);
	        String ano = readStringInArray("fecha_inicio", 2, json);
	        fecha_inicio = new Fecha_inicio(dia, mes, ano);
	        String estado_obra = readString("estado_obra", json);
	        
	        ArrayList<String> materiales_usados = new ArrayList<String>();
	        for (int i = 0; i < getLengthOfAnArray("materiales_usados", json); i++) {
	       	 String material_usado = readStringInArray("materiales_usados", i, json);
	       	 materiales_usados.add(material_usado);
	        }
	        
	        ArrayList<String> registro = new ArrayList<String>();
	        for (int i = 0; i < getLengthOfAnArray("registro", json); i++) {
	       	 String _registro = readStringInArray("registro", i, json);
	       	 registro.add(_registro);
	        }
	        
	        return new Proyecto(_nombre_proyecto, rut, nombre, direccion, subsidio, monto_subsidio, presupuesto, duracion_obra, fecha_inicio, estado_obra, 
	       		 materiales_usados, registro);
		}
	}
	
	public ArrayList<Materiales> getMateriales() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("Materiales");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<Materiales> materiales = new ArrayList<Materiales>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
	      			 String descripcion = readString("DESCRIPCIÓN", json);
	      			 String unidad = null;
	      			 try {
	      				 unidad = readString("UNIDAD", json);
	      			 } catch (JSONException e) {
	      				 // Do nothing;
	      			 }
	      			 String precio_vigente_uf = readString("PRECIO VIGENTE  (UF)", json);
	      			 materiales.add(new Materiales(descripcion, unidad, precio_vigente_uf));
		        }
		        return materiales;
		}
	}
	
	public ArrayList<ItemA> getItemA() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemA");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemA> itemA = new ArrayList<ItemA>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // DO NOTHING;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemA.add(new ItemA(partida, designacion, unidad, preciototal));
		        }
		        return itemA;
		}
	}
	public ArrayList<ItemB> getItemB() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemB");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemB> itemB = new ArrayList<ItemB>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // Do nothing;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemB.add(new ItemB(partida, designacion, unidad, preciototal));
		        }
		        return itemB;
		}
	}
	public ArrayList<ItemC> getItemC() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemC");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemC> itemC = new ArrayList<ItemC>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // Do nothing;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemC.add(new ItemC(partida, designacion, unidad, preciototal));
		        }
		        return itemC;
		}
	}
	public ArrayList<ItemD> getItemD() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemD");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemD> itemD = new ArrayList<ItemD>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // Do nothing;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemD.add(new ItemD(partida, designacion, unidad, preciototal));
		        }
		        return itemD;
		}
	}
	public ArrayList<ItemF> getItemF() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemF");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemF> itemF = new ArrayList<ItemF>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // Do nothing;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemF.add(new ItemF(partida, designacion, unidad, preciototal));
		        }
		        return itemF;
		}
	}
	public ArrayList<ItemH> getItemH() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemH");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemH> itemH = new ArrayList<ItemH>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // Do nothing;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemH.add(new ItemH(partida, designacion, unidad, preciototal));
		        }
		        return itemH;
		}
	}
	public ArrayList<ItemI> getItemI() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("ItemI");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<ItemI> itemI = new ArrayList<ItemI>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
	      			 //String _id = readString("_id", json);
		       	 String partida = null;
		       	 try {
		       		 partida = readString("Partida", json);
		       	 } catch (JSONException e) {
		       		 // Do nothing;
		       	 }
	      			 String designacion = readString("designacion", json);
	      			 String unidad = readString("unidad", json);
	      			 double preciototal = readDouble("preciototal", json);
	      			 itemI.add(new ItemI(partida, designacion, unidad, preciototal));
		        }
		        return itemI;
		}
	}
	
	public ArrayList<Proyecto> getProyectos() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection("Proyectos");
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<Proyecto> itemI = new ArrayList<Proyecto>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
		       	 
		       	 String _id = readObjectId("_id", json);
		       	 String _nombre_proyecto = readString("nombre_proyecto", json);
			        String rut = readString("rut", json);
			        Nombre nombre;
			        String _nombre = readStringInArray("nombre", 0, json);
			        String apellido1 = readStringInArray("nombre", 1, json);
			        String apellido2 = readStringInArray("nombre", 2, json);
			        nombre = new Nombre(_nombre, apellido1, apellido2);
			        Direccion direccion;
			        String calle = readStringInArray("Direccion", 0, json);
			        String numero = readStringInArray("Direccion", 1, json);
			        String CCP = readStringInArray("Direccion", 2, json);
			        direccion = new Direccion(calle, numero, CCP);
			        String subsidio = readString("subsidio", json);
			        String monto_subsidio = readString("monto_subsidio", json);
			        String presupuesto = readString("presupuesto", json);
			        String duracion_obra = readString("duracion_obra", json);
			        Fecha_inicio fecha_inicio;
			        String dia = readStringInArray("fecha_inicio", 0, json);
			        String mes = readStringInArray("fecha_inicio", 1, json);
			        String ano = readStringInArray("fecha_inicio", 2, json);
			        fecha_inicio = new Fecha_inicio(dia, mes, ano);
			        String estado_obra = readString("estado_obra", json);
			        
			        ArrayList<String> materiales_usados = new ArrayList<String>();
			        for (int i = 0; i < getLengthOfAnArray("materiales_usados", json); i++) {
			       	 String material_usado = readStringInArray("materiales_usados", i, json);
			       	 materiales_usados.add(material_usado);
			        }
			        ArrayList<String> registro = new ArrayList<String>();
			        for (int i = 0; i < getLengthOfAnArray("registro", json); i++) {
			       	 String _registro = readStringInArray("registro", i, json);
			       	 registro.add(_registro);
			        }
	      			 itemI.add(new Proyecto(_id, _nombre_proyecto, rut, nombre, direccion, subsidio, monto_subsidio, presupuesto, duracion_obra, fecha_inicio, estado_obra, materiales_usados, registro));
		        }
		        return itemI;
		}
	}
	
}
