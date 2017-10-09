package iurii.job.interview.crypto;

import java.util.HashSet;
import java.util.Set;

public class TxHandler {

    private final UTXOPool utxoPool;
    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */
    public TxHandler(UTXOPool utxoPool) {
        this.utxoPool = new UTXOPool(utxoPool);
    }

    /**
     * @return true if:
     * (1) all outputs claimed by {@code tx} are in the current UTXO pool, 
     * (2) the signatures on each input of {@code tx} are valid, 
     * (3) no UTXO is claimed multiple times by {@code tx},
     * (4) all of {@code tx}s output values are non-negative, and
     * (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
     *     values; and false otherwise.
     */
    public boolean isValidTx(Transaction tx) {
        int index = 0;
        UTXOPool uniqueUTXO = new UTXOPool();
        double sumInput = 0;
        double sumOutput = 0;
        for(Transaction.Input input : tx.getInputs()) {
            UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
            // (1)
            if (!utxoPool.contains(utxo)) {
                return false;
            }
            // 2
            Transaction.Output txOutput = utxoPool.getTxOutput(utxo);
            if (!Crypto.verifySignature(txOutput.address, tx.getRawDataToSign(index), input.signature)) {
                return false;
            }
            // 3
            if (uniqueUTXO.contains(utxo)) {
                return false;
            }
            uniqueUTXO.addUTXO(utxo, txOutput);
            sumInput += txOutput.value;
            index++;
        }
        for(Transaction.Output output : tx.getOutputs()) {
            sumOutput += output.value;
            // 4
            if (output.value < 0) {
                return false;
            }
        }
        // 5
        return sumInput >= sumOutput;
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
        Set<Transaction> validTxs = new HashSet<>();

        for (Transaction tx : possibleTxs) {
            if (isValidTx(tx)) {
                validTxs.add(tx);
                for (Transaction.Input in : tx.getInputs()) {
                    UTXO utxo = new UTXO(in.prevTxHash, in.outputIndex);
                    utxoPool.removeUTXO(utxo);
                }
                for (int i = 0; i < tx.numOutputs(); i++) {
                    Transaction.Output out = tx.getOutput(i);
                    UTXO utxo = new UTXO(tx.getHash(), i);
                    utxoPool.addUTXO(utxo, out);
                }
            }
        }
        return validTxs.toArray(new Transaction[validTxs.size()]);
    }

}
