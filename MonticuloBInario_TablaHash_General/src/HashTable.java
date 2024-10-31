//PARA EVITAR LAS COLICIONES HEMOS UTILIZADO HASHING ENLAZADO

public class HashTable <K, V> {
//atributos
private HashNode<K, V>[] buckets;//Tabla formada por los elementos
private int numBuckets; // Tamaño del array de buckets
private int size; // Número de elementos en la tabla

//constructor
public HashTable() {
    numBuckets = 10; //Tamaño de la tabla
    buckets = new HashNode[numBuckets];
    size = 0;
}

//getters para el size del Bucket
public int getBucketsSize() {
    return buckets.length;
}

//Metodos
// Función hash que acepta cadenas y números, devuelve el indice donde va a estar guardado el valor
private int hash(K key) {
    if (key instanceof Integer) {
        // Para enteros, devuelve x % tamañoTabla
        return Math.abs((Integer) key % buckets.length);//nos aseguramos q no de numero negativo
    } else if (key instanceof String) {
        // Para cadenas, utiliza la función de hash proporcionada
        return hash_chain((String) key, buckets.length);
    } else {
        // Si el tipo de clave no es soportado, lanzar excepción
        throw new IllegalArgumentException("Tipo de clave no soportado");
    }
}

// Función hash para cadenas
public static int hash_chain(String key, int tableSize) {
    int hashVal = 0;
    for (int i = 0; i < key.length(); i++) {
        hashVal = (hashVal * 128 + key.charAt(i)) % tableSize;
    }
    return hashVal;
}

// Método para insertar un valor
public void put(V value) {
    K key = (K) value; // Usar el valor como clave
    int index;

    // Determinar el índice basado en el tipo del valor
    if (value instanceof Integer) {
        index = hash(key);
    } else if (value instanceof String) {
        index = hash(key);
    } else {
        throw new IllegalArgumentException("Unsupported key type");
    }

    HashNode<K, V> newNode = new HashNode<>(key, value); // Crear un nuevo nodo

    if (buckets[index] == null) {
        // Si el bucket está vacío, colocar el nuevo nodo
        buckets[index] = newNode;
    } else {
        // Manejar colisiones usando una lista enlazada
        HashNode<K, V> current = buckets[index];

        // Recorrer la lista hasta el final
        while (current.next != null) {
            current = current.next; // Ir al siguiente nodo
        }
        // Agregar el nuevo nodo al final de la lista enlazada
        current.next = newNode;
    }
    size++; // Incrementar el tamaño de la tabla hash
}

 // Método para obtener todos los valores en un bucket
 public void printBucket(int index) {
    HashNode<K, V> current = buckets[index];
    if (current == null) {
        System.out.println(index + ": está vacío.");
        return;
    }

    System.out.print(index + ": ");
    while (current != null) {
        System.out.print("[" + current.value + "] ");
        current = current.next;
    }
    System.out.println();
    }
}
