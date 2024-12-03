import math
import numpy as np
import pandas as pd

file_path = 'Balanced250.csv'
data = pd.read_csv(file_path)
train_data = []
test_data = []

for breed, group in data.groupby('breed'):
    shuffled_group = group.sample(frac=1, random_state=51).reset_index(drop=True)

    split_index = len(shuffled_group) // 2
    train_data.append(shuffled_group.iloc[:split_index])
    test_data.append(shuffled_group.iloc[split_index:])

train_data = pd.concat(train_data).reset_index(drop=True)
test_data = pd.concat(test_data).reset_index(drop=True)


class Neuron:
    def __init__(self, prev_layer):
        self.prev_layer = prev_layer
        self.weights = np.random.standard_normal(size=len(prev_layer))
        self.bias = 0.
        self.output = 0.

    def activate(self):
        sumo = 0
        for index in range(len(self.prev_layer)):
            sumo += self.prev_layer[index].output * self.weights[index]
        self.output = max(0., sumo + self.bias)


class NeuralNetwork:
    def __init__(self, nr_inputs, hidden_layer_sizes, nr_outputs):
        self.nr_hidden_layers = len(hidden_layer_sizes)
        self.inputs = [Neuron(list()) for _ in range(nr_inputs)]
        self.hidden_layers = [list() for _ in range(self.nr_hidden_layers)]
        for index, layer_size in enumerate(hidden_layer_sizes):
            if index == 0:
                self.hidden_layers[index] = [Neuron(self.inputs) for _ in range(layer_size)]
            else:
                self.hidden_layers[index] = [Neuron(self.hidden_layers[index - 1]) for _ in range(layer_size)]
        self.outputs = [Neuron(self.hidden_layers[-1]) for _ in range(nr_outputs)]

    def calculate_outputs_for_entry(self, entry):
        for index, attribute in enumerate(entry):
            self.inputs[index].output = attribute
            for layer in self.hidden_layers:
                for neuron in layer:
                    neuron.activate()
        for neuron in self.outputs:
            neuron.activate()
        exponents = [math.e ** neuron.output for neuron in self.outputs]
        exp_sum = sum(exponents)
        for index, neuron in enumerate(self.outputs):
            neuron.output = exponents[index] / exp_sum

    def calculate_loss(self, observation):
        observed = [0 for _ in self.outputs]
        observed[observation - 1] = 1
        return sum([-math.log(neuron.output) * observed[i] for i, neuron in enumerate(self.outputs)])


nn = NeuralNetwork(25, [10, 10], 13)
nn.calculate_outputs_for_entry([2, 1, 2, 4, 3, 4, 3, 2, 2, 1, 4, 4, 4, 4, 4, 3, 2, 4, 2, 4, 4, 4, 3, 1, 5])
print(nn.calculate_loss(13))

