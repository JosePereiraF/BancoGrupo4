package project.imprimeRelatorio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import project.entities.Pessoa;
import project.entities.conta.Conta;
import project.extrato.Deposito;
import project.extrato.Saque;
import project.extrato.Transferencia;

public class ImprimeRelatorio {

    public static void imprimeSaque(Saque saque, Conta conta,String path,double valor){ //Imprime o comprovante do saque
            Double valorSaque = valor;
            Double valorTaxa = saque.getTaxa();
            Double valorSacado = valorSaque-valorTaxa;
            Double saldoConta = conta.getSaldo();
            try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
                buffWrite.append("----------------SAQUE----------------");
                buffWrite.newLine();
                buffWrite.append("Valor do saque:   "+valorSaque.toString()+"\n");
                buffWrite.append("Valor da taxa:    "+valorTaxa.toString()+"\n");
                buffWrite.append("Valor do sacado:  "+valorSacado.toString()+"\n");
                buffWrite.append("saldo:            "+saldoConta+"\n");
            } catch (IOException e) {
                System.err.println("Erro ao realizar o saque: " + e.getMessage());
            }
       
    }

    public static void imprimeDeposito(Deposito deposito, Conta conta,String path, double valor){ //Imprime o comprovante do depósito
        Double valorDeposito = valor;
        Double valorTaxa = deposito.getTaxa();
        Double valorDepositado = valorDeposito-valorTaxa;
        Double saldoConta = conta.getSaldo();
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            buffWrite.append("----------------DEPOSITO----------------");
            buffWrite.newLine();
            buffWrite.append("Valor do deposito:        "+valorDeposito.toString()+"\n");
            buffWrite.append("Valor da taxa:            "+valorTaxa.toString()+"\n");
            buffWrite.append("Valor do depositadojose:  "+valorDepositado.toString()+"\n");
            buffWrite.append("saldo:                    "+saldoConta+"\n");
        } catch (IOException e) {
            System.err.println("Erro ao realizar o deposito: " + e.getMessage());
        }
   
    }//listaPessoa, contaOrigem, contaDestino, origem, valor,path
    public static void imprimeTransferencia(Map <String, Pessoa> listaPessoa,Conta contaOrigem, Conta contaDestino,Transferencia transferencia,double valor,String path){ 
        Double valorTransferencia = valor;//Imprime o comprovante da transfência
        Double valorTaxa = transferencia.getTaxa();
        Double valorDescontado = valorTransferencia+valorTaxa;

        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            buffWrite.append("----------------Transferencia----------------");
            buffWrite.newLine();
            buffWrite.append("Dados do pagador \n");
            buffWrite.append("nome:                "+listaPessoa.get(contaOrigem.getCpf()).getNome()+"\n");
            buffWrite.append("cpf:                 "+listaPessoa.get(contaOrigem.getCpf()).getCpf()+"\n");
            buffWrite.append("Agência:             "+contaOrigem.getNumeroAgencia()+"\n");
            buffWrite.append("Tipo de conta:       "+contaOrigem.getTipoConta().name()+"\n");
            buffWrite.append("Numero da conta:     "+contaOrigem.getNumeroDaConta()+"\n");
            buffWrite.newLine();
            buffWrite.append("Dados do recebedor \n");
            buffWrite.append("nome:                "+listaPessoa.get(contaDestino.getCpf()).getNome()+"\n");
            buffWrite.append("cpf:                 "+listaPessoa.get(contaDestino.getCpf()).getCpf()+"\n");
            buffWrite.append("Agência:             "+contaDestino.getNumeroAgencia()+"\n");
            buffWrite.append("Tipo de conta:       "+contaDestino.getTipoConta().name()+"\n");
            buffWrite.append("Numero da conta:     "+contaDestino.getNumeroDaConta()+"\n");
            buffWrite.append("Valor da tranferêcia:"+valorDescontado+"\n");
            buffWrite.append("Valor da taxa:       " +valorTaxa+"\n");
            buffWrite.append("Valor da transferido:" +valorTransferencia+"\n");
        } catch (IOException e) {
            System.err.println("Erro ao realizar a transferencia: " + e.getMessage());
        }
      
    }
    public static void imprimeSaldo(Conta conta,Map<String, Pessoa> listaPessoa, String path){
//Iprime o saldo da pessoa
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            buffWrite.append("----------------SALDO----------------");
            buffWrite.newLine();
            buffWrite.append("Dados da conta \n");
            buffWrite.append("Nome:              "+listaPessoa.get(conta.getCpf()).getNome());
            buffWrite.append("CPF:               " + conta.getCpf());
            buffWrite.append("Agência:           "+ conta.getNumeroAgencia());
            buffWrite.append("Tipo de conta:     " + conta.getTipoConta().name());
            buffWrite.append("Número da conta:   " + conta.getNumeroDaConta() + "\n");
            buffWrite.append("Saldo:             " + conta.getSaldo());
        } catch (IOException e) {
            System.err.println("Erro ao realizar o saldo: " + e.getMessage());
        }

    }

    public static void imprimeTotalArrecadado(String saqueFormatada, String depositoFormatada,
            String transferenciaFormatada, int quantSac, int quantDeposito, int quantTransferencia, String totalFormatada,String path) {
                
                    try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
                        buffWrite.append("----------------TOTAL ARRECADADO----------------");
                        buffWrite.newLine();
                        buffWrite.append("Dados de arrecadamento da taxa\n");
                        buffWrite.append("Saque:              "+"foram feitas "+quantSac+" no valor de: "+saqueFormatada);
                        buffWrite.append("Deposito:              "+"foram feitas "+quantDeposito+" no valor de: "+depositoFormatada);
                        buffWrite.append("O banco arrecadou o total de "+totalFormatada);
                       
                    } catch (IOException e) {
                        System.err.println("Erro ao realizar o total arrecado: " + e.getMessage());
                    }
    }

    public static void imprimeCalcRendimentos(LocalDate hoje, LocalDate dataFinal, double jurosMensal,
            double jurosGanhos, double valorSimulado, String path) { //IMprime a simulação do rendimento da poupança
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
                    buffWrite.append("----------------SIMULAÇÃO----------------");
                    buffWrite.newLine();
                    buffWrite.append("Dia de hoje:                     " + hoje.format(formatter));
                    buffWrite.append("Dia da simulação:                " + dataFinal.format(formatter));
                    buffWrite.append("Com um juros de                  " + jurosMensal + "% ao mês.\n" + "Com um investimento inicial de \tR$");
                    buffWrite.append("Com um investimento inicial de R$"+ valorSimulado );
                    buffWrite.append("Você terá um retorno de \tR$     " + jurosGanhos );
                    buffWrite.append("Tendo um total de R$             " + (valorSimulado + jurosGanhos) );
                } catch (IOException e) {
                    System.err.println("Erro ao realizar a simulação de rendimento: " + e.getMessage());
                }
    }
    public static void imprimeCalcCapital(double valorTotal, String path){// Imprime o cálculo do capital do banco 
        
            try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            buffWrite.append("----------------CAPITAL DO BANCO----------------");
            buffWrite.newLine();
            buffWrite.append("O banco Serratec tem o capital de "+ valorTotal);
            } catch (IOException e) {
            System.err.println("Erro ao realizar o capital do banco: " + e.getMessage());
            }
    }//imprime total de contas
    public static void imprimeTotalDeContasBanco(int numContas,String path,int numeroDaAgencia){
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            buffWrite.append("----------------TOTAL DE CONTAS DO BANCO----------------");
            buffWrite.newLine();
            buffWrite.append("O banco Serratec tem "+ numContas+" registradas na agência " + numeroDaAgencia);
            } catch (IOException e) {
            System.err.println("Erro ao realizar o total de contas do banco: " + e.getMessage());
            }

    }//imprime o relatório
    public static void relatorioClientes(ArrayList<String> relatorio, String path){
       
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            for (String relatorio1 : relatorio) {
                buffWrite.append(relatorio1);
                            } 
            } catch (IOException e) {
                System.err.println("Erro ao realizar o relatório dos clientes: " + e.getMessage());
        }
    }//imprime Extrato
    public static void imprimeExtrato(ArrayList<Saque> saques,ArrayList<Deposito> depositos,ArrayList<Transferencia> transferencias, String path ){

        
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter (path))){
            buffWrite.append("----------------SAQUES----------------");
            buffWrite.newLine();
           for(Saque saque : saques){
            buffWrite.append(saque.toString());
           }
           buffWrite.append("----------------DEPOSITOS----------------");
           buffWrite.newLine();
          for(Deposito deposito : depositos){
           buffWrite.append(deposito.toString());
          }
          buffWrite.append("----------------TANSFERENCIA----------------");
           buffWrite.newLine();
          for(Transferencia transferencia : transferencias){
           buffWrite.append(transferencia.toString());
          }
        } catch (IOException e) {
            System.err.println("Erro ao realizar a impressão do extrato: " + e.getMessage());
        }
    }
        
}