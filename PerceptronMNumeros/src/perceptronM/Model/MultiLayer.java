/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronM.Model;

import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.LearningRule;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.core.learning.TrainingElement;
import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.LMS;
import org.neuroph.util.TransferFunctionType;
import perceptronM.GUI.GUI;

/**
 *
 * @author PRETXEL-H
 */
public class MultiLayer {
        private static String CLASSNAME = MultiLayer.class.getName();
        private static double  SalidaTest[][] = new double[10][10]; 
        public static NeuralNetwork redMulticapa = null;
        
public static void Ini() {

    Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Init Generator Pesos y b\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
    
    int maxIterations = Const.epoch;
    
// Crear Conjunto de pruebas
TrainingSet<SupervisedTrainingElement> trainingSet = new TrainingSet<SupervisedTrainingElement>(40, 10);
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{1,0,0,0,0,0,0,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,0,1,1,0,0,1,1,1,0,1,1,1,1,0,1,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0}, new double[]{0,1,0,0,0,0,0,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,0,1,1,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,1,1,1,1,1}, new double[]{0,0,1,0,0,0,0,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,0,1,1,0,1,1,0,0,0,1,1,0,0,1,1,0,0,0,0,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{0,0,0,1,0,0,0,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,0,0,1,1,0,0,1,1,1,0,1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1}, new double[]{0,0,0,0,1,0,0,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,1,0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{0,0,0,0,0,1,0,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{0,0,0,0,0,0,1,0,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0}, new double[]{0,0,0,0,0,0,0,1,0,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{0,0,0,0,0,0,0,0,1,0}));
trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{0,0,0,0,0,0,0,0,0,1}));


TrainingSet<SupervisedTrainingElement> trainingSet2 = new TrainingSet<SupervisedTrainingElement>(40, 10);
trainingSet2.addElement(new SupervisedTrainingElement(new double[]{0,0,0,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0}, new double[]{0,0,0,0,0,0,0,0,0,0}));

// Crear Red Multicapa
NeuralNetwork neuralNet  = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 40, 20, 10);



//Agregar Backpropagation 
neuralNet.setLearningRule(new BackPropagation());

((BackPropagation) neuralNet.getLearningRule()).setMaxError(Const.errorObjt);//0-1
((BackPropagation) neuralNet.getLearningRule()).setLearningRate(Const.alpha);//0-1
((BackPropagation) neuralNet.getLearningRule()).setMaxIterations(maxIterations);//0-1






neuralNet.learn(trainingSet);

Logic.NumEpocas = ((BackPropagation) neuralNet.getLearningRule()).getCurrentIteration();
System.out.println(((BackPropagation) neuralNet.getLearningRule()).getPreviousEpochError());

// Prueba el Percepetron multicapa
System.out.println("Prueba Red Multicapa");
testNeuralNetwork(neuralNet, trainingSet);

VerificarAprendizaje();

redMulticapa = neuralNet;

// Guarda la red entrenada
neuralNet.save("RedMNumeros.nnet");


/*




*/

}

public static void testNeuralNetwork(NeuralNetwork nnet, TrainingSet tset) {
    
     Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Test\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
    
         int k = 0;
         
        for (Iterator it = tset.trainingElements().iterator(); it.hasNext();) {
            TrainingElement trainingElement = (TrainingElement) it.next();
            nnet.setInput(trainingElement.getInput());
            nnet.calculate();
            double[] networkOutput = nnet.getOutput();
            
            for (int i=0;i<networkOutput.length;i++){
                networkOutput[i] = Math.round(networkOutput[i]);
                SalidaTest[i][k] = Math.round(networkOutput[i]);
            }
            Const.LogTexto.append("Input: " + Arrays.toString(trainingElement.getInput())).append("\n");
            Const.LogTexto.append("Output: " + Arrays.toString(networkOutput)).append("\n");
            GUI.txtLogger.append(Const.LogTexto.toString());
            Const.LogTexto.setLength(0);
            k++;
            //System.out.print("Input: " + Arrays.toString(trainingElement.getInput()) );
            //System.out.println(" Output: " + Arrays.toString(networkOutput) );
        }
}


public static double[] testGridNeuralNetwork(NeuralNetwork nnet, TrainingSet tset) {
    
     Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Test\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
    
         int k = 0;
         double[] networkOutput = null;
        for (Iterator it = tset.trainingElements().iterator(); it.hasNext();) {
            TrainingElement trainingElement = (TrainingElement) it.next();
            nnet.setInput(trainingElement.getInput());
            nnet.calculate();
            networkOutput = nnet.getOutput();
            
            for (int i=0;i<networkOutput.length;i++){
                networkOutput[i] = Math.round(networkOutput[i]);
            }
            Const.LogTexto.append("Input: " + Arrays.toString(trainingElement.getInput())).append("\n");
            Const.LogTexto.append("Output: " + Arrays.toString(networkOutput)).append("\n");
            GUI.txtLogger.append(Const.LogTexto.toString());
            Const.LogTexto.setLength(0);
            k++;
            //System.out.print("Input: " + Arrays.toString(trainingElement.getInput()) );
            //System.out.println(" Output: " + Arrays.toString(networkOutput) );
        }
        return networkOutput;
}


public static void VerificarAprendizaje(){
    
    int ve = 0;
    for (int i=0;i<Const.TotalDigitos;i++){
        for (int j=0;j<Const.TotalDigitos;j++){
            
            if (Const.target_1[j][i] == SalidaTest[j][i]){
               ve++; 
            }
            
        }
    }
    
    System.out.println(ve);
    if (ve == 100){
        Logic.aprendio = true;
    }
}


public static int EvaluarGrid(){
    
    TrainingSet<SupervisedTrainingElement> trainingSet2 = new TrainingSet<SupervisedTrainingElement>(40, 10);

    double in[] = new double[Const.TotalDigitos*4];
    
    for (int i=0;i<Const.TotalDigitos*4;i++){
        in[i] = Const.prueba[i][0];
    }
    
    trainingSet2.addElement(new SupervisedTrainingElement(in, new double[]{0,0,0,0,0,0,0,0,0,0}));

    double salidaGrid[] = testGridNeuralNetwork(redMulticapa, trainingSet2);
    int cont = 0;
    
    for (int i =0;i<Const.TotalDigitos;i++){
        cont = 0;
        for(int j = 0; j<Const.TotalDigitos;j++){
            
            if (Const.target_1[j][i] == salidaGrid[j]){
                cont++;
            }   
        }
        if(cont == 10){
            return i;
        }
    }
    
    return -1;
}


}
