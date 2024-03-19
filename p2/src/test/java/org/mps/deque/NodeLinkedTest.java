package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LinkedNode Tests")
class NodeLinkedTest {

    @Nested
    @DisplayName("Item Tests")
    class ItemTests {
        @Test
        @DisplayName("Get Item")
        void getItem() {
            LinkedNode<Integer> node = new LinkedNode<>(5, null, null);
            assertEquals(5, node.getItem());
        }

        @Test
        @DisplayName("Set Item")
        void setItem() {
            LinkedNode<Integer> node = new LinkedNode<>(5, null, null);
            node.setItem(10);
            assertEquals(10, node.getItem());
        }
    }

    @Nested
    @DisplayName("Previous Node Tests")
    class PreviousNodeTests {
        @Test
        @DisplayName("Get Previous Node")
        void getPrevious() {
            LinkedNode<Integer> previousNode = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(5, previousNode, null);
            assertEquals(previousNode, node.getPrevious());
        }

        @Test
        @DisplayName("Set Previous Node")
        void setPrevious() {
            LinkedNode<Integer> previousNode = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(5, null, null);
            node.setPrevious(previousNode);
            assertEquals(previousNode, node.getPrevious());
        }
    }

    @Nested
    @DisplayName("Next Node Tests")
    class NextNodeTests {
        @Test
        @DisplayName("Get Next Node")
        void getNext() {
            LinkedNode<Integer> nextNode = new LinkedNode<>(7, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(5, null, nextNode);
            assertEquals(nextNode, node.getNext());
        }

        @Test
        @DisplayName("Set Next Node")
        void setNext() {
            LinkedNode<Integer> nextNode = new LinkedNode<>(7, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(5, null, null);
            node.setNext(nextNode);
            assertEquals(nextNode, node.getNext());
        }
    }

    @Nested
    @DisplayName("Terminal Node Tests")
    class TerminalNodeTests {
        @Test
        @DisplayName("Is First Node")
        void isFirstNode() {
            LinkedNode<Integer> node = new LinkedNode<>(5, null, null);
            assertTrue(node.isFirstNode());
        }

        @Test
        @DisplayName("Is Last Node")
        void isLastNode() {
            LinkedNode<Integer> node = new LinkedNode<>(5, null, null);
            assertTrue(node.isLastNode());
        }

        @Test
        @DisplayName("Is Not a Terminal Node")
        void isNotATerminalNode() {
            LinkedNode<Integer> previousNode = new LinkedNode<>(3, null, null);
            LinkedNode<Integer> nextNode = new LinkedNode<>(7, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(5, previousNode, nextNode);
            assertTrue(node.isNotATerminalNode());
        }
    }
}
