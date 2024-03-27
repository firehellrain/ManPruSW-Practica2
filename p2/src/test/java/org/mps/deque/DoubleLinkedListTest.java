package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DoubleLinkedList Tests")
class DoubleLinkedListTest {

    @Nested
    @DisplayName("Prepend Operation Tests")
    class PrependOperationTests {
        @Test
        @DisplayName("Prepend to Empty List")
        void prependToEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.prepend(5);
            assertEquals(1, list.size());
            assertEquals(5, list.first());
            assertEquals(5, list.last());
        }

        @Test
        @DisplayName("Prepend to Non-Empty List")
        void prependToNonEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.prepend(5);
            list.prepend(10);
            assertEquals(2, list.size());
            assertEquals(10, list.first());
            assertEquals(5, list.last());
        }
    }

    @Nested
    @DisplayName("Append Operation Tests")
    class AppendOperationTests {
        @Test
        @DisplayName("Append to Empty List")
        void appendToEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            assertEquals(1, list.size());
            assertEquals(5, list.first());
            assertEquals(5, list.last());
        }

        @Test
        @DisplayName("Append to Non-Empty List")
        void appendToNonEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            list.append(10);
            assertEquals(2, list.size());
            assertEquals(5, list.first());
            assertEquals(10, list.last());
        }
    }

    @Nested
    @DisplayName("Delete Operation Tests")
    class DeleteOperationTests {
        @Test
        @DisplayName("Delete First Element from Empty List")
        void deleteFirstFromEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, list::deleteFirst);
        }

        @Test
        @DisplayName("Delete Last Element from Empty List")
        void deleteLastFromEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, list::deleteLast);
        }

        @Test
        @DisplayName("Delete First Element from List with One Element")
        void deleteFirstFromListWithOneElement() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.prepend(5);
            list.deleteFirst();
            assertEquals(0, list.size());
            assertThrows(DoubleLinkedQueueException.class, list::first);
            assertThrows(DoubleLinkedQueueException.class, list::last);
        }

        @Test
        @DisplayName("Delete Last Element from List with One Element")
        void deleteLastFromListWithOneElement() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            list.deleteLast();
            assertEquals(0, list.size());
            assertThrows(DoubleLinkedQueueException.class, list::first);
            assertThrows(DoubleLinkedQueueException.class, list::last);
        }

        @Test
        @DisplayName("Delete First Element from List with Multiple Elements")
        void deleteFirstFromListWithMultipleElements() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            list.append(10);
            list.deleteFirst();
            assertEquals(1, list.size());
            assertEquals(10, list.first());
            assertEquals(10, list.last());
        }

        @Test
        @DisplayName("Delete Last Element from List with Multiple Elements")
        void deleteLastFromListWithMultipleElements() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            list.append(10);
            list.deleteLast();
            assertEquals(1, list.size());
            assertEquals(5, list.first());
            assertEquals(5, list.last());
        }
    }

    @Nested
    @DisplayName("Size and Access Tests")
    class SizeAndAccessTests {
        @Test
        @DisplayName("Size of Empty List")
        void sizeOfEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            assertEquals(0, list.size());
        }

        @Test
        @DisplayName("Access First Element of Non-Empty List")
        void accessFirstOfNonEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            assertEquals(5, list.first());
        }

        @Test
        @DisplayName("Access Last Element of Non-Empty List")
        void accessLastOfNonEmptyList() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            list.append(5);
            list.append(10);
            assertEquals(10, list.last());
        }

        @Test
        @DisplayName("Access First Element of Empty List Throws Exception")
        void accessFirstOfEmptyListThrowsException() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, list::first);
        }

        @Test
        @DisplayName("Access Last Element of Empty List Throws Exception")
        void accessLastOfEmptyListThrowsException() {
            DoubleLinkedQueue<Integer> list = new DoubleLinkedList<>();
            assertThrows(DoubleLinkedQueueException.class, list::last);
        }
    }
}
