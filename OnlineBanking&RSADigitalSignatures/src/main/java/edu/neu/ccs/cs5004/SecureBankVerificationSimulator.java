package edu.neu.ccs.cs5004;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.neu.ccs.cs5004.KeyPair.KeyPair;

public class SecureBankVerificationSimulator {
  private Bank bank;
  private List<Client> clients = new ArrayList<>();



  public void generateClients(int requestedNum){
    Random rand = new Random();
    Set<Id> idSet = new HashSet<>();
    for(int i = 0; i < requestedNum; i++){
      Id id = new Id(rand.nextInt(100000));
      KeyPair keyPair = RSA.generateKeyPair();
      Client client = new Client(id,keyPair);
      while(idSet.contains(client.getId())){
        id = new Id(rand.nextInt(100000));
        keyPair = RSA.generateKeyPair();
        client = new Client(id,keyPair);
      }
      idSet.add(client.getId());
      clients.add(client);
      bank.getPublicKeyMap().put(client.getId(),client.getKeyPair().getPublicKey());
      DepositLimit randDeposit = new DepositLimit(rand.nextInt(10000));
      bank.getDepositLimitMap().put(client.getId(),randDeposit);
      WithdrawalLimit withdrawalLimit = new WithdrawalLimit(rand.nextInt(10000));
      bank.getWithdrawalLimitMap().put(client.getId(),withdrawalLimit);
    }
  }


  public List<Pair> generatePairs(Integer numVerification, int per) {
    List<Pair> pairs = new ArrayList<>();

    Random rand = new Random();
    int countInvalid = numVerification * per / 100;

    for(int i = 0; i < countInvalid; i++){
      Message message = new Message(rand.nextInt(30000));
      DS dsInvalid = new DS(BigInteger.valueOf(rand.nextInt()));
      Pair pairInvalid = new Pair(message,dsInvalid);
      pairs.add(pairInvalid);
      Integer index = rand.nextInt(this.clients.size());
      Client client = clients.get(index);
      bank.getMessageMap().put(client.getId(),message);
      bank.getSignatureMap().put(client.getId(),pairInvalid);
    }

    for(int j = countInvalid; j < numVerification; j++){
      Message message2 = new Message(rand.nextInt(30000));
      Integer index = rand.nextInt(this.clients.size());
      Client client = clients.get(index);
      DS dsValid = new DS(RSA.encrypt(message2,client.getKeyPair().getPrivateKey()));
      Pair pairValid = new Pair(message2,dsValid);
      pairs.add(pairValid);
      bank.getMessageMap().put(client.getId(),message2);
      bank.getSignatureMap().put(client.getId(),pairValid);
    }
    return pairs;
  }
  public List<Record> processRequest() {
    List<Record> res = new ArrayList<>();
    for(Id id : bank.getSignatureMap().keySet()){
      res.add(bank.generateRecord(id));
    }
    return res;
  }


  public void simulation(int numOfUniqueBankClient, int numOfUniqueVerifications,
                              int percentageOfInvalidMsg, String outPutFile){
    generateClients(numOfUniqueBankClient);
    generatePairs(numOfUniqueVerifications,percentageOfInvalidMsg);
    List<Record> records = processRequest();
    Write.write(outPutFile,records);
  }



}
