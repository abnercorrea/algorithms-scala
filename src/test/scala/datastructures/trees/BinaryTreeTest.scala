package datastructures.trees

class BinaryTreeTest extends org.scalatest.flatspec.AnyFlatSpec {

    val data: Array[Int] = (1 to 10).toArray
    val tree: BinaryTree[Int] = BinaryTree(data)

    "BinaryTree in order traversal" should "be the values ordered" in {
        val expected = data

        assert(tree.inOrder().sameElements(expected))
    }

    "BinaryTree pre order traversal" should "match values" in {
        val expected = Array(5, 2, 1, 3, 4, 8, 6, 7, 9, 10)

        assert(tree.preOrder().sameElements(expected))
    }

    "BinaryTree post order traversal" should "match values" in {
        val expected = Array(1, 4, 3, 2, 7, 6, 10, 9, 8, 5)

        assert(tree.postOrder().sameElements(expected))
    }

    "BinaryTree level order traversal" should "match values" in {
        val expected = Array(5, 2, 8, 1, 3, 6, 9, 4, 7, 10)

        assert(tree.levelOrder().sameElements(expected))
    }

}
