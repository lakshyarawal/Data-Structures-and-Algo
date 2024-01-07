class MinStack:
    def __init__(self):
        self.head = None

    def push(self, x):
        if self.head is None:
            self.head = self.Node(x, x, None)
        else:
            self.head = self.Node(x, min(x, self.head.min), self.head)

    def pop(self):
        self.head = self.head.next

    def top(self):
        return self.head.val

    def getMin(self):
        return self.head.min

    class Node:
        def __init__(self, val, min_val, next_node):
            self.val = val
            self.min = min_val
            self.next = next_node

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()