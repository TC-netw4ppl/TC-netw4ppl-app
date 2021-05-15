package netw4ppl.ines.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Relation extends JSONObject {

    public Relation(){
        super();
    }

    public Relation(Person from, String key_relation, Person to, String date_ajout, String detail_input) throws JSONException {
        super();

        this.put("from_unique_id", from.getInfoByKey("unique_id"));
        this.put("from_full_name", from.getInfoByKey("full_name"));
        this.put("to_unique_id", to.getInfoByKey("unique_id"));
        this.put("to_full_name", to.getInfoByKey("full_name"));
        this.put("relation", key_relation);
        this.put("date", date_ajout);
        this.put("detail", detail_input);
    }

    public Relation(String infos_relat) throws JSONException {
        super(infos_relat);
    }

    public String getInfoByKey(String key) {
        String res = "";
        try {
            res = this.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean isSameRelation(Relation relat) {
        boolean res_uid_from = false;
        boolean res_uid_to = false;
        boolean res_relation = false;
        try {
            res_uid_from = this.getString("from_unique_id").equals(relat.getString("from_unique_id"));
            res_relation = this.getString("relation").equals(relat.getString("relation"));
            res_uid_to = this.getString("to_unique_id").equals(relat.getString("to_unique_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res_relation && res_uid_from && res_uid_to;
    }

    public String getFrom() {
        return (this.getInfoByKey("from_unique_id") + " - " + this.getInfoByKey("from_full_name"));
    }

    public String getTo() {
        return (this.getInfoByKey("to_unique_id") + " - " + this.getInfoByKey("to_full_name"));
    }

    public String getDetails() {

        return (this.getInfoByKey("detail"));
    }

    public String getRelation_type() {

        return (this.getInfoByKey("relation"));
    }
}
