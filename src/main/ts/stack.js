export class Stack {
    items = []

    push(element) {
        this.items.push(element)
    }

    pop() {
        return this.items.pop()
    }
    peek() {
        return this.items[this.items.length - 1]
    }

    clear() {
        this.items = [];
    }
    isEmpty() {
        return this.items.length == 0
    }

    size() {
        return this.items.length
    }

    toString() {
        let resultString = ''
        let size = this.size()
        let i = 1
        for (let item of this.items) {
            resultString += item
            if (i < size) {
                resultString += " => "
            }
            i++
        }
        return resultString
    }
}

