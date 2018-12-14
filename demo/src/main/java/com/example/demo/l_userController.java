package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class l_userController extends JdbcDaoSupport {
@Autowired
 DataSource dataSource;

@PostConstruct
  private void initialize(){
  setDataSource(dataSource);
  }
 
 
@RequestMapping(value = "/create", method = RequestMethod.POST)
     public List<l_user> HelloWorld( @RequestBody l_user myvar3 )
 {
  List<l_user> customers = new ArrayList<>();
  String query = "INSERT INTO l_user (B_USER_ID,B_UNIT_ID,B_USER_NAME,B_USER_ROLE,B_MKR_ID,B_MKR_DATE,B_CKR_ID,B_CKR_DATE,B_USER_TITLE,B_USER_FN,B_USER_MAIL,B_USER_STATUS,B_USER_ACTION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
    getJdbcTemplate().update(query, new Object[]{ myvar3.getb_user_id(),myvar3.getb_unit_id(),myvar3.getb_user_name(),myvar3.getb_user_role(),myvar3.getb_mkr_id(), myvar3.getb_mkr_date(),myvar3.getb_ckr_id(), myvar3.getb_ckr_date(),myvar3.getb_user_title(),myvar3.getb_user_fn(),myvar3.getb_user_mail(),myvar3.getb_user_status(),myvar3.getb_user_action()});
    customers.add(myvar3);
    return customers;
 }
@RequestMapping(value = "/update/{myvar}", method = RequestMethod.PUT)
public List<l_user> update( @RequestBody l_user myvar3,@PathVariable("myvar") String myvar)
{
 List<l_user> customers = new ArrayList<>();
 String query = "UPDATE l_user SET B_USER_ID=?,B_UNIT_ID=?,B_USER_NAME=?,B_USER_ROLE=?,B_MKR_ID=?,B_MKR_DATE=?,B_CKR_ID=?,B_CKR_DATE=?,B_USER_TITLE=?,B_USER_FN=?,B_USER_MAIL=?,B_USER_STATUS=?,B_USER_ACTION=? WHERE B_USER_ID=?" ;
    getJdbcTemplate().update(query, new Object[]{myvar3.getb_user_id(),myvar3.getb_unit_id(), myvar3.getb_user_name(),myvar3.getb_user_role(),myvar3.getb_mkr_id(), myvar3.getb_mkr_date(),myvar3.getb_ckr_id(), myvar3.getb_ckr_date(),myvar3.getb_user_title(),myvar3.getb_user_fn(),myvar3.getb_user_mail(),myvar3.getb_user_status(),myvar3.getb_user_action(),myvar});
  customers.add(myvar3);
  return customers;
}
@RequestMapping(value = "/userdet/{myvar3}/{limit}", method = RequestMethod.GET)
public List<l_user> checkpageuser(@PathVariable("myvar3") String myvar3,@PathVariable("limit") Integer limit)
{
 String query = "SELECT * FROM l_user WHERE B_USER_NAME LIKE ? ORDER BY B_USER_ID LIMIT ?";
    List<Map<String, Object>> userRow = getJdbcTemplate().queryForList(query,"%"+myvar3+"%",limit);
    List<l_user> user = new ArrayList<l_user>();
    for(Map<String, Object> row:userRow){
     l_user users = new l_user();
    users.setb_user_id((int)row.get("B_USER_ID"));
    users.setb_unit_id((int)row.get("B_UNIT_ID"));
    users.setb_user_name((String)row.get("B_USER_NAME"));
    users.setb_user_role((String)row.get("B_USER_ROLE"));
    users.setb_mkr_id((int)row.get("B_MKR_ID"));
    users.setb_mkr_date((String)row.get("B_MKR_DATE"));
     users.setb_ckr_id((int)row.get("B_CKR_ID"));
   users.setb_ckr_date((String)row.get("B_CKR_DATE"));
   users.setb_user_title((String)row.get("B_USER_TITLE"));
   users.setb_user_fn((String)row.get("B_USER_FN"));
   users.setb_user_mail((String)row.get("B_USER_MAIL"));
   users.setb_user_status((String)row.get("B_USER_STATUS"));
   users.setb_user_action((String)row.get("B_USER_ACTION")); 
   user.add(users);
  }

   return user;
}
@RequestMapping(value = "/totpage/{limit}", method = RequestMethod.GET)
public List<Integer> pages(@PathVariable("limit") Integer limit)
{
 String sql = "SELECT count(*) FROM l_user";
 int count = getJdbcTemplate().queryForObject(
          sql, Integer.class);
 double count1 = Math.ceil((double)count/(double)limit);
 List<Integer> pages = new ArrayList<Integer>();
 for(int i=0;i<count1;i++)
 {
  pages.add(i);
 }
   return pages;
}

@RequestMapping(value = "/count/{limit}", method = RequestMethod.GET)
public List<Double> counting(@PathVariable("limit") Integer limit)
{
String sql = "SELECT count(*) FROM l_user";
int count = getJdbcTemplate().queryForObject(
         sql, Integer.class);
double count1 = Math.ceil((double)count/(double)limit);
List<Double> pages = new ArrayList<Double>();
pages.add(count1);
return pages;
}

@RequestMapping(value = "/pages/{limit}/{offset}", method = RequestMethod.GET)
public List<l_user> pages(@PathVariable("limit") Integer limit,@PathVariable("offset") Integer offset)
{
 String query = "SELECT * FROM l_user ORDER BY B_USER_ID LIMIT ? OFFSET ?";
 List<Map<String, Object>> userRow = getJdbcTemplate().queryForList(query,limit,offset);
   List<l_user> user = new ArrayList<l_user>();
    for(Map<String, Object> row:userRow){
    l_user users = new l_user();
        users.setb_user_id((int)row.get("B_USER_ID"));
       users.setb_unit_id((int)row.get("B_UNIT_ID"));
       users.setb_user_name((String)row.get("B_USER_NAME"));
      users.setb_user_role((String)row.get("B_USER_ROLE"));
      users.setb_mkr_id((int)row.get("B_MKR_ID"));
      users.setb_mkr_date((String)row.get("B_MKR_DATE"));
users.setb_ckr_id((int)row.get("B_CKR_ID"));
users.setb_ckr_date((String)row.get("B_CKR_DATE"));
users.setb_user_title((String)row.get("B_USER_TITLE"));
users.setb_user_fn((String)row.get("B_USER_FN"));
users.setb_user_mail((String)row.get("B_USER_MAIL"));
 users.setb_user_status((String)row.get("B_USER_STATUS"));
users.setb_user_action((String)row.get("B_USER_ACTION"));
user.add(users);
}
return user;
}
@RequestMapping(value = "/checkdelete/{myvar}",method = RequestMethod.DELETE)
public List<l_user> checkdelete(@PathVariable("myvar") Integer myvar){
String query1 = "DELETE FROM l_user WHERE B_USER_ID= ?";
getJdbcTemplate().update(query1, myvar);
String query2 = "SELECT * FROM l_user";
List<Map<String, Object>> userRow = getJdbcTemplate().queryForList(query2);

List<l_user> user = new ArrayList<l_user>();
for(Map<String, Object> row:userRow){
 l_user users = new l_user();
 users.setb_user_id((int)row.get("B_USER_ID"));
users.setb_unit_id((int)row.get("B_UNIT_ID"));
users.setb_user_name((String)row.get("B_USER_NAME"));
users.setb_user_role((String)row.get("B_USER_ROLE"));
users.setb_mkr_id((int)row.get("B_MKR_ID"));
users.setb_mkr_date((String)row.get("B_MKR_DATE"));
users.setb_ckr_id((int)row.get("B_CKR_ID"));
users.setb_ckr_date((String)row.get("B_CKR_DATE"));
users.setb_user_title((String)row.get("B_USER_TITLE"));
users.setb_user_fn((String)row.get("B_USER_FN"));
 users.setb_user_mail((String)row.get("B_USER_MAIL"));
 users.setb_user_status((String)row.get("B_USER_STATUS"));
users.setb_user_action((String)row.get("B_USER_ACTION"));
 user.add(users);
}
return user;
}
@RequestMapping(value = "/moduser/{id}", method = RequestMethod.GET)
public List<l_user> HelloUser(@PathVariable("id") Integer id)
{
  String query = "SELECT * FROM l_user WHERE B_USER_ID= ?";
List<Map<String, Object>> userRow = getJdbcTemplate().queryForList(query,id);

List<l_user> user = new ArrayList<l_user>();
for(Map<String, Object> row:userRow){
 l_user users = new l_user();
 users.setb_user_id((int)row.get("B_USER_ID"));
 users.setb_unit_id((int)row.get("B_UNIT_ID"));
 users.setb_user_name((String)row.get("B_USER_NAME"));
 users.setb_user_role((String)row.get("B_USER_ROLE"));
users.setb_mkr_id((int)row.get("B_MKR_ID"));
 users.setb_mkr_date((String)row.get("B_MKR_DATE"));
 users.setb_ckr_id((int)row.get("B_CKR_ID"));
 users.setb_ckr_date((String)row.get("B_CKR_DATE"));
 users.setb_user_title((String)row.get("B_USER_TITLE"));
 users.setb_user_fn((String)row.get("B_USER_FN"));
 users.setb_user_mail((String)row.get("B_USER_MAIL"));
 users.setb_user_status((String)row.get("B_USER_STATUS"));
 users.setb_user_action((String)row.get("B_USER_ACTION"));
 user.add(users);
}

return user;
}
@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
public List<l_user> HelloUser123(@PathVariable("id") Integer id)
{
 String query = "SELECT * FROM l_user WHERE B_USER_ID= ?";
List<Map<String, Object>> userRow = getJdbcTemplate().queryForList(query,id);

List<l_user> user = new ArrayList<l_user>();
for(Map<String, Object> row:userRow){
 l_user users = new l_user();
 users.setb_user_id((int)row.get("B_USER_ID"));
 users.setb_unit_id((int)row.get("B_UNIT_ID"));
 users.setb_user_name((String)row.get("B_USER_NAME"));
users.setb_user_role((String)row.get("B_USER_ROLE"));
 users.setb_mkr_id((int)row.get("B_MKR_ID"));
 users.setb_mkr_date((String)row.get("B_MKR_DATE"));
 users.setb_ckr_id((int)row.get("B_CKR_ID"));
 users.setb_ckr_date((String)row.get("B_CKR_DATE"));
 users.setb_user_title((String)row.get("B_USER_TITLE"));
 users.setb_user_fn((String)row.get("B_USER_FN"));
 users.setb_user_mail((String)row.get("B_USER_MAIL"));
 users.setb_user_status((String)row.get("B_USER_STATUS"));
 users.setb_user_action((String)row.get("B_USER_ACTION")); 
 user.add(users);
}

return user;
}
}




