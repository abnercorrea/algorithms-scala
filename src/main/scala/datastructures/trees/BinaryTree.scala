package datastructures.trees

import Ordering.Implicits._
import scala.collection.mutable

class BinaryTree[T : Ordering]() {
    // Parameters without val or var are private values.
    case class Node(data: T, var left: Node = null, var right: Node = null)

    // Members are public by default.
    private var _root: Node = _

    private def insert(node: Node, data: T): Node = {
        if (node == null) {
            return Node(data)
        }

        if (data < node.data) {
            node.left = insert(node.left, data)
        }
        else if (data > node.data) {
            node.right = insert(node.right, data)
        }

        node
    }

    private def preOrder(node: Node, result: mutable.Buffer[T]): Unit = {
        if (node == null) return
        result += node.data
        preOrder(node.left, result)
        preOrder(node.right, result)
    }

    private def inOrder(node: Node, result: mutable.Buffer[T]): Unit = {
        if (node == null) return
        inOrder(node.left, result)
        result += node.data
        inOrder(node.right, result)
    }

    private def postOrder(node: Node, result: mutable.Buffer[T]): Unit = {
        if (node == null) return
        postOrder(node.left, result)
        postOrder(node.right, result)
        result += node.data
    }

    def insert(data: T): Unit = {
        _root = insert(_root, data)
    }

    def preOrder(): Seq[T] = {
        val result = mutable.Buffer[T]()
        preOrder(_root, result)
        result
    }

    def inOrder(): Seq[T] = {
        val result = mutable.Buffer[T]()
        inOrder(_root, result)
        result
    }

    def postOrder(): Seq[T] = {
        val result = mutable.Buffer[T]()
        postOrder(_root, result)
        result
    }

    def levelOrder(): Seq[T] = {
        val result = mutable.Buffer[T]()
        val queue = mutable.Queue[Node]()
        if (_root != null) queue.enqueue(_root)
        while (queue.nonEmpty) {
            val node = queue.dequeue()
            result += node.data
            if (node.left != null) queue.enqueue(node.left)
            if (node.right != null) queue.enqueue(node.right)
        }
        result
    }
}

object BinaryTree {
    def apply[T : Ordering](): BinaryTree[T] = new BinaryTree[T]()

    def apply[T : Ordering](data: Array[T]): BinaryTree[T] = {
        val tree = BinaryTree[T]()

        buildBinarySearchTree(tree, data.sorted, 0, data.length - 1)

        tree
    }

    def buildBinarySearchTree[T : Ordering](tree: BinaryTree[T], data: Array[T], left: Int, right: Int): Unit = {
        if (left > right) return

        val mid = (left + right) / 2
        tree.insert(data(mid))

        buildBinarySearchTree(tree, data, left, mid - 1)
        buildBinarySearchTree(tree, data, mid + 1, right)
    }
}
