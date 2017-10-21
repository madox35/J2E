
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugo Jové (sécurité)
 */
public class UtilisateurDAO extends DAO<JUtilisateurBean, String> {
    
    private static UtilisateurDAO instanceCompteDAO;
   
    UtilisateurDAO(){
        super();
    }
    
    @Override
    public boolean create(JUtilisateurBean obj) {
      try {
        PreparedStatement st = null;
        st = connect.prepareStatement("INSERT INTO result (id,nom,prenom,login) VALUES(?,?,?,?)");
        st.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
        st.setString(2, obj.getNom());
        st.setString(3, obj.getPrenom());
        st.setString(4, obj.getLogin());
        st.executeUpdate();
        connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean delete(JUtilisateurBean obj) {
        return false;
    }
    
    @Override
    public boolean update(JUtilisateurBean obj) {
        return false;
    }

    @Override
    public JUtilisateurBean find(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public JUtilisateurBean findByName(String nom, String prenom){
        JUtilisateurBean bean = new JUtilisateurBean();
        PreparedStatement st = null;
        
        try {
            
            st = connect.prepareStatement("SELECT * FROM TEST.RESULT WHERE NOM = ? and PRENOM = ?");
            st.setString(1, nom);
            st.setString(2, prenom);
            ResultSet rs = st.executeQuery();
     
            if(rs.next()){
                bean.setNom(rs.getString("NOM"));
                bean.setPrenom(rs.getString("PRENOM"));
                bean.setLogin(rs.getString("LOGIN"));
            }
            else{
                return null;
            }
            return bean;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } 
        return null;
    }
    
    public JUtilisateurBean findById(String id) {
        
        JUtilisateurBean bean = new JUtilisateurBean();
        PreparedStatement st = null;
        
        try {
            
            st = connect.prepareStatement("SELECT * FROM TEST.RESULT WHERE ID = ?");
            st.setString(1, id);
             
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                
                bean.setNom(rs.getString("NOM"));
                bean.setPrenom(rs.getString("PRENOM"));
                bean.setLogin(rs.getString("LOGIN"));
            }
            
            return bean;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } 
        return null;
    }
    
    public ArrayList<JUtilisateurBean> findAll(){
        
        PreparedStatement st = null;
        
        try {
            st = connect.prepareStatement("SELECT * FROM TEST.RESULT");
            ResultSet rs = st.executeQuery();
            
            ArrayList<JUtilisateurBean> listeJUtilisateurs = new ArrayList<>();
            
            while(rs.next()){
                JUtilisateurBean bean = findById(rs.getString("ID"));
                listeJUtilisateurs.add(bean);
            }
            return listeJUtilisateurs;
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return null;
    }
    
    public int getNombreEnregistre(){
        
        PreparedStatement st = null;
        
        try {
            st = connect.prepareStatement("SELECT COUNT(*) FROM TEST.RESULT");
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                 return rs.getInt(1);
            } else {
                System.err.println("error: could not get the record counts");
            }
            
        }catch(Exception e){
            System.err.println(e);
        }
        return 0;
    }
    
    public static UtilisateurDAO getInstance() {
        if (null == instanceCompteDAO) { // Premier appel
            instanceCompteDAO = new UtilisateurDAO();
        }
        return instanceCompteDAO;
    }
}
