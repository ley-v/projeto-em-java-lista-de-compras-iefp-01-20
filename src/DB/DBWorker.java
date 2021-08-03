/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import estruturasBase.ArrayListObservable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;

import main.Alimentos;
import main.ListaDeCompras;
import main.ListaNome;

/**
 *
 * @author Ley
 */
public class DBWorker {
    
    String baseDados = "lista_de_compras";
    String servidor = "192.168.56.102";
    String user = "root";
    String password = "123";
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    String url = "jdbc:mysql://" + servidor + ":3306/" + baseDados + "?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    
    public boolean guardarAlimento(/*ListaDeCompras lc*/Alimentos a) {
//        Alimentos a = lc;
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
//
//            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
//            String sql = "SELECT * FROM loja";
//            rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nome = rs.getString("nome");
//
//                System.out.println("\n\n\nId Loja: " + id + "\nNome: " + nome);
//            }
//            System.out.println("Dados carregados com sucesso.");

            // === GRAVACAO DE DADOS NA BASE DE DADOS ==========================
            st.executeUpdate("INSERT INTO alimentos(nome, mercado, preco_KgL) "
                    + "VALUES('" + a.getNomeAlimento() + "', '" + a.getNomeMercado() + "', " + a.getPrecoKgL() + "); ");

//            System.out.println(la.getNomeAlimento() +", "+ la.getNomeMercado() +", "+ la.getPrecoKgL());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean guardarListaNome(ListaNome l) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === GRAVACAO DE DADOS NA BASE DE DADOS ==========================
            st.executeUpdate("INSERT INTO lista_nome(nome) "
                    + "VALUES('" + l.getNomeLista() + "'); ");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean buscarAlimento(ArrayListObservable lista) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "SELECT * FROM alimentos";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Alimentos a = new Alimentos(rs.getString("nome"), rs.getString("mercado"), rs.getDouble("preco_KgL"));
                a.setId(rs.getString("id"));
                lista.add(a);
                
            }
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
    
    public boolean apagarAlimento(String id) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === APAGAR REGISTOS DA BASE DE DADOS ==========================
            st.executeUpdate("DELETE FROM alimentos WHERE id = " + id + ";");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean buscarListaNome(ArrayList lista) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "SELECT * FROM lista_nome";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                ListaNome l = new ListaNome();
                l.setId(rs.getString("id"));
                l.setNomeLista(rs.getString("nome"));
                lista.add(l);
                
            }
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
    
    public boolean apagarListaNome(int id) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === APAGAR REGISTOS DA BASE DE DADOS ==========================
            st.executeUpdate("DELETE FROM lista_nome WHERE id = " + id + ";");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean guardarLinha(String quantidade, String alimentos_id, String lista_nome_id) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === GRAVACAO DE DADOS NA BASE DE DADOS ==========================
            st.executeUpdate("INSERT INTO linha(quantidade, alimentos_id, lista_nome_id) "
                    + "VALUES(" + quantidade + ", " + alimentos_id + ", " + lista_nome_id + "); ");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean buscarListaDeCompras(ArrayListObservable lista, int idListaNome) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "select a.nome, a.mercado, l.quantidade, l.id, a.preco_KgL\n"
                    + "from alimentos a inner join linha l on a.id = l.alimentos_id inner join lista_nome ln on l.lista_nome_id = ln.id\n"
                    + "where ln.id = " + idListaNome + ";";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                ListaDeCompras l = new ListaDeCompras();
                l.setAlimento(rs.getString("nome"));
                l.setMercado(rs.getString("mercado"));
                double quantidade = rs.getDouble("quantidade");
                l.setQuantidade(quantidade);
                double precoKg = rs.getDouble("preco_KgL");
                DecimalFormat df = new DecimalFormat("##0.00");
//                double precoDoAlimento = Math.round(precoKg * (quantidade / 1000));
                double precoDoAlimento = (precoKg * (quantidade / 1000));
                NumberFormat f = new DecimalFormat("##0,00");
//                f.format(precoDoAlimento);
//                l.setPreco(Double.parseDouble(String.format("%.2f",precoDoAlimento)));
//double d;
//                l.setPreco(Double.parseDouble(f.format(Double.toString(precoDoAlimento))));
                l.setPreco((String.format("%.2f", precoDoAlimento)).replace(",", ".")); //*********UM ANO DEPOIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                l.setId(rs.getString("id"));

                lista.add(l);
            }
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
    
    public boolean apagarAlimentoLC(String id) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === APAGAR REGISTOS DA BASE DE DADOS ==========================
            st.executeUpdate("DELETE FROM linha WHERE id = " + id + ";");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean apagarLinhasRelacionadasAListaNome(int id) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === APAGAR REGISTOS DA BASE DE DADOS ==========================
            st.executeUpdate("DELETE FROM linha WHERE lista_nome_id = " + id + ";");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
    public boolean apagarLinhasRelacionadasAoAlimento(String id) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === APAGAR REGISTOS DA BASE DE DADOS ==========================
            st.executeUpdate("DELETE FROM linha WHERE alimentos_id = " + id + ";");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }
    
}
