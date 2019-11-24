package com.firstinfo.dart.job.xml;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntityPK;

@Service
public class ClobUpdate {

    @Autowired
    private EntityManager entityManager;
    
    public void updateClob(String clob, int contentSn) throws SQLException {

        Session session = entityManager.unwrap(Session.class);
        
        session.doWork(new Work() {
            
            @Override
            public void execute(Connection conn) throws SQLException {
                PreparedStatement pstmt = null;
                StringReader sr=null;
                
                try{
                    sr=new StringReader(clob);
                    String sql = "UPDATE TB_PA_DART_DOC_CONTENT  SET CONTENT = ? WHERE content_sn=?";
                    pstmt = conn.prepareStatement(sql);
                    int colIndex=1;
                    pstmt.setCharacterStream(colIndex++, sr, clob.length() );
                    pstmt.setInt(colIndex++, contentSn);
                    int i=pstmt.executeUpdate();
                    System.out.println("update cnt:" + i + ":" + contentSn);
                }catch(SQLException se){
                    se.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (pstmt != null) { try { pstmt.close(); } catch (Exception ex) {}}
                }
            }
        }); 
            
    }

}
