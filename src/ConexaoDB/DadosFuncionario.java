/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoDB;

import classesbasicas.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Candido
 */
public class DadosFuncionario extends Conexao{
    public void cadastrarF(Funcionario funcionario) throws Exception {

        String sql = "INSERT INTO funcionario (cpf, nome, logradouro, numero, bairro, cidade, estado, cep, email,"
                + " telefone)";
        sql += " VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = this.conectarComParametros(sql);
        pst.setString(1, funcionario.getCpf());
        pst.setString(2, funcionario.getNome());
        pst.setString(3, funcionario.getLogradouro());
        pst.setInt(4, funcionario.getNumero());
        pst.setString(5, funcionario.getBairro());
        pst.setString(6, funcionario.getCidade());
        pst.setString(7, funcionario.getEstado());
        pst.setInt(8, funcionario.getCep());
        pst.setString(9, funcionario.getEmail());
        pst.setInt(10, funcionario.getTelefone());

        //executando a instrução
        pst.executeUpdate();

        desconectar();
    }
    public ArrayList<Funcionario> listarF(Funcionario filtroF) throws Exception{
        ArrayList<Funcionario> listafuncionarios = new ArrayList<>();
        String sql = "SELECT cpf, nome, logradouro, numero, bairro, cidade, estado, cep, email, telefone FROM funcionario"
                + " WHERE cpf is not null";
        if (filtroF.getNome() != null && filtroF.getNome().equals("") == false) {
            sql += " and nome like'%"+ filtroF.getNome()+"%'";
        }
        PreparedStatement cmd = this.conectarComParametros(sql);
        //executando a instrução sql
        ResultSet leitor = cmd.executeQuery(sql);
        while (leitor.next()) {
            Funcionario fun = new Funcionario();
            fun.setNome(leitor.getString("nome"));
            fun.setCpf(leitor.getString("cpf"));
            fun.setLogradouro(leitor.getString("logradouro"));
            fun.setNumero(leitor.getInt("numero"));
            fun.setBairro(leitor.getString("bairro"));
            fun.setCidade(leitor.getString("cidade"));
            fun.setEstado(leitor.getString("estado"));
            fun.setCep(leitor.getInt("cep"));
            fun.setEmail(leitor.getString("email"));
            fun.setTelefone(leitor.getInt("telefone"));
            listafuncionarios.add(fun);
        }
        return listafuncionarios;
        
    }
    public void editarF(Funcionario funcionario) throws Exception{
        
        //Statement conn = conectar();
        String sql = "UPDATE funcionario SET cpf=?, nome=?, logradouro=?, numero=?, bairro=?, cidade=?, estado=?, cep=?,"
                + " email=?, telefone=? WHERE cpf=?";
        PreparedStatement pst = this.conectarComParametros(sql);
        pst.setString(1, funcionario.getCpf());
        pst.setString(2, funcionario.getNome());
        pst.setString(3, funcionario.getLogradouro());
        pst.setInt(4, funcionario.getNumero());
        pst.setString(5, funcionario.getBairro());
        pst.setString(6, funcionario.getCidade());
        pst.setString(7, funcionario.getEstado());
        pst.setInt(8, funcionario.getCep());
        pst.setString(9, funcionario.getEmail());
        pst.setInt(10, funcionario.getTelefone());
        pst.setString(11, funcionario.getCpf());

        //executando a instrução
        pst.executeUpdate();

        desconectar();
                
    }
    public  void deletarF(Funcionario funcionario) throws Exception{
        //Statement conn = conectar();
        String sql = "DELETE FROM funcionario WHERE cpf=?";
        PreparedStatement pst = this.conectarComParametros(sql);
        pst.setString(1, funcionario.getCpf());
        //executando a instrução
        pst.executeUpdate();
        desconectar();
        
    }
    
}
