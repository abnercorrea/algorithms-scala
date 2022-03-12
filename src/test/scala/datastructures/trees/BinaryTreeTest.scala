package datastructures.trees

class BinaryTreeTest extends org.scalatest.flatspec.AnyFlatSpec {

    "BinaryTree in order traversal" should "be the values ordered" in {
        val data = (1 to 10).toArray
        val expected = data

        val tree = BinaryTree(data)

        assert(tree.inOrder().sameElements(data))
    }

    "BinaryTree pre order traversal" should "match values" in {
        val data = (1 to 10).toArray
        val expected = Array(5, 2, 1, 3, 4, 8, 6, 7, 9, 10)

        val tree = BinaryTree(data)

        assert(tree.preOrder().sameElements(expected))
    }

    "BinaryTree post order traversal" should "match values" in {
        val data = (1 to 10).toArray
        val expected = Array(1, 4, 3, 2, 7, 6, 10, 9, 8, 5)

        val tree = BinaryTree(data)

        assert(tree.postOrder().sameElements(expected))
    }

    "BinaryTree level order traversal" should "match values" in {
        val data = (1 to 10).toArray
        val expected = Array(5, 2, 8, 1, 3, 6, 9, 4, 7, 10)

        val tree = BinaryTree(data)

        assert(tree.levelOrder().sameElements(expected))
    }

}
