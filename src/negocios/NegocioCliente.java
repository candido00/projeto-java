/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import ConexaoDB.DadosCliente;
import classesbasicas.Cliente;
import validacaodecampos.SomenteLetras;

/**
 *
 * @author Candido
 */
public class NegocioCliente {
    
    public void cadastrar(Cliente cliente) throws Exception {
        if (cliente.getNome() == null) {
            throw new Exception("Informar o nome do cliente");
        }
        if (cliente.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do cliente");
        }
        if (cliente.getNome().length() < 5) {
            throw new Exception("Nome muito curto");
        }
        if (cliente.getNome().length() > 100) {
            throw new Exception("Insira no máximo 100 caracteres!");
        }
        if (cliente.getNome().matches("[a-zA-Z_\\s]+") == false) {
            throw new Exception("O nome deve ser preenchido apenas com letras");
        }
        
        
        if (cliente.getBairro() == null) {
            throw new Exception("Informar o bairro!");  
        }
        if (cliente.getBairro().trim().equals("")==true) {
            throw new Exception("informar o bairro!"); 
        }
        if (cliente.getBairro().length()< 4) {
            throw new Exception("Bairro muito curto");     
        }
        if (cliente.getBairro().length() > 50) {
            throw new Exception("Insira no máximo 50 caracteres!");
        }
        if (cliente.getBairro().matches("[a-zA-Z_\\s]+") == false) {
            throw new Exception("O bairro deve ser preenchido apenas com letras");
        }
        
        
        
        DadosCliente dados = new DadosCliente();
        dados.cadastrar(cliente);
    }
}
