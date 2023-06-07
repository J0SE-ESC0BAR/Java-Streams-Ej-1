import networkx as nx
import matplotlib.pyplot as plt

# Crear un gráfico dirigido
G = nx.DiGraph()

# Añadir nodos y arcos al gráfico
G.add_edge('CIM', 'EST', weight=3)
G.add_edge('EST', 'VITE', weight=5)
G.add_edge('EST', 'ELEC', weight=5)
G.add_edge('EST', 'VENT', weight=5)
G.add_edge('VITE', 'RETE', weight=2)
G.add_edge('VENT', 'EXT', weight=2)
G.add_edge('ELEC', 'INT', weight=4)
G.add_edge('RETE', 'PINT', weight=3)
G.add_edge('EXT', 'PINT', weight=4)
G.add_edge('PINT', 'INT', weight=2)

# Dibujar el gráfico
pos = nx.spring_layout(G)
nx.draw(G, pos, with_labels=True)
labels = nx.get_edge_attributes(G, 'weight')
nx.draw_networkx_edge_labels(G, pos, edge_labels=labels)

plt.show()
