# Functional Programming

![cover](https://cdn.hashnode.com/res/hashnode/image/upload/v1691853775339/3b697a52-9efc-400d-8487-71562a9b588f.png?w=1600&h=840&fit=crop&crop=entropy&auto=compress,format&format=webp)

After I [discussed the uniqueness of Clojure being a Lisp](/posts/clojure-as-a-lisp.html), this article will go into the other obvious difference between Clojure and JavaScript, which is that Clojure is a more functional language than JS. I am saying "more functional" because I don't think of it as a binary classification. Functional programming can be done in both languages, but Clojure supports it to a greater extent.

This topic gets discussed a lot when introducing functional languages like Clojure or FP-inspired features in other languages, like high-order array methods in JS. I will recap most of that info here and add my two cents.

## Functions as First-Class Citizens

It's literally in the name! In FP, you write most (or all) of your code as functions. The functions could operate directly on data or be composed together to produce larger functions. That brings us to the concept of high-order functions, which are functions that take functions as arguments and/or return functions as output. That ties in with many concepts like composition, partial application, currying, etc.

I will take function composition as an example using the Clojure code below.

```clojure
(defn prob->odds
  [prob]
  (/ prob (- 1 prob)))

(def logit (comp clojure.math/log prob->odds))
```

The first part defines a function that converts a probability to odds. For example, a probability of 0.25 (25%) is 0.25:0.75 odds, so 1:3 or ~0.3333. Next, I compose the functions `clojure.math/log` (the natural log) and the function I wrote first to yield my own implementation of the [logit (log odds) function](https://en.wikipedia.org/wiki/Logit). This way of composing and defining `logit` is known as "point-free style" because I didn't need to specify a parameter. I directly operated on functions to yield another function. This is similar to the mathematical representation *h = f ∘ g* which corresponds to *h(x) = f(g(x))*.

In JavaScript, you can write functions and pass them as values. There are also implementations of high-order functions as array methods. However, there is no way to directly compose them as far as I know. The answer to something like this would usually be to implement `comp` in JS. I believe it would be done with something like this:

```javascript
// Using Recursion
function comp(fns) {
    if (fns.length === 0) {
        return (x) => x
    } else {
        return (x) => fns[0](comp(fns.slice(1))(x))
    }
}

// Using Reduce
function comp2(fns) {
    return fns.reverse().reduce((compFn, nextFn) => {
        return (x) => nextFn(compFn(x))
    }, (x) => x)
}
```

A problem with something like this is that it works only with functions that are called directly with values as arguments (more on that later). In other words, we can't compose object methods. Also, the lack of the point-free style makes it a bit more verbose and less elegant.

Another important characteristic of functions in FP is that they are preferred to be *pure*. The meaning of functional purity is that a function must give the same output every time it takes the same input (it's also called *referential transparency* if you're feeling sophisticated). It does not rely on the "outer world" or change it in the process. Of course, at some point, you will have to make a *side effect* like interacting with databases or changing the DOM, but FP encourages minimizing and isolating such behavior while keeping the majority of the functions pure for simplicity and predictability. Clojure specifically is one of the functional languages that are pragmatic about side effects, unlike a language like Haskell which has stronger enforcement of functional purity.

## Abstraction

One problem I find with FP in JS is that you cannot really escape the "object-orientedness" of it. Popular FP features like `map` and `reduce` are implemented as array methods. One issue is that the syntax is not consistent: there is `function(args)`, and there is `object.method(args)`, and the latter is much more common. You can chain methods but that depends on their return types. Extending an object prototype with new methods is non-idiomatic and generally discouraged in JS, and writing top-level functions breaks the method pattern.

Methods are JS' (or rather OOP's) way of associating a group of functions with certain data structures. Clojure has, in my humble opinion, a more elegant way of doing that. It has the notion of *abstractions* in the sense that if a data structure falls under one abstraction, then a certain group of functions can be called on that data structure. For example, there is the sequence abstraction which applies to stuff like vectors, lists, hash-maps, etc. That means that a family of functions like `map` and `filter` can be used with these data structures. Using this approach, the language ends up with a uniform way of writing code for similar data structures, plus some interesting language features like using keywords as functions to get a corresponding value from a map.

```clojure
(def person {:name "John" :age 32}) 

;; Keywords can be called like functions
(ifn? :anykeyword)   ; true
(:name person)       ; "John"
(:hair-color person) ; nil
```

## Immutable Data Structures

As pointed out earlier, pure functions are free from side effects. One side effect that's worth its own discussion is mutating data structures. Programming is fundamentally about processing data, and the common languages we use today usually do this by modifying an existing data structure in place (like filtering an array or modifying a property of an object). In FP, functions do their jobs by returning a modified copy, leaving the original object intact. An obvious problem is the inefficient copying of objects, and this is where immutable data structures come into play.

Immutable/persistent data structures are implemented in functional languages like Clojure with the so-called *structural sharing*. My intuitive understanding of it is that the modified "copy" actually shares data with the original structure. This is possible because they are immutable and can always be used as a reference for future modified copies. You get that out of the box with Clojure but not JS as far as I know.

## Lazy Evaluation

That's another feature commonly seen in FP. It means that expressions are evaluated only when needed. This means that some functions will partially evaluate a vector and return when its job is done without going through every value. It also means that you can make infinite vectors!

Take this code for example:

```clojure
(take 10 (range))
```

The `range` function when called with no arguments gives an infinite sequence of integers starting from 0, and `take` with 10 as an argument subsets the first 10 elements of the vector. Instead of returning an error or running forever, the expression simply evaluates the needed part of the "infinite" vector and returns 10 numbers. This has some obvious efficiency gains, but I find it pretty cool in general!

## Conclusion

You can implement almost any concept in any language, but we can't deny that a certain language usually makes some paradigms easier to work with than others. This is why in JS you'd either use the functional stuff you're given by the language as-is, or you'd have to put the time and effort (or libraries) to implement functional features that aren't built in.

On a final note, I like FP. It always feels simpler and more intuitive for me than OOP. Functions are kind of a universal concept that I saw in math and Excel before I saw it in programming. In contrast, a particular object class and its methods form a special world of their own that you need to understand before interacting with them. My personal story with FP is the topic of a separate article, but at the time of writing this, I am still going strong with learning FP and Clojure in particular.

And that ends my piece, I hope It gave you a good overview of FP concepts.

* * *

Cover images source: [https://www.qulix.com/uncategorized/functional-programming/](https://www.qulix.com/uncategorized/functional-programming/)
