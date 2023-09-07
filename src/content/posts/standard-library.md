# Standard Library

![cover](https://i.imgur.com/nhBxOOc.png)

In this article, I will explore what I learned in Clojure's standard library in comparison to JavaScript's. Without trying to get the most precise definition of "standard library," for the sake of this discussion, I mean things that you can do with the base distribution of the language. This article in particular will discuss basic stuff that should be applicable regardless of the environment or runtime. What I say about Clojure applies to ClojureScript, and what I say about JS applies to the browser and Node.

Without further ado, let's get into it.

## Why Care About Standard Libraries?

Relying more on a standard library means relying less on (external) dependencies. So, in a world where everyone just `npm install`s anything and everything, allow me to go a bit over why standard libraries matter. I wrote a full article, [Dependencyphobia](/posts/dependencyphobia.html), going over why I have issues with dependencies, but I'll give a quick summary of them here:

* They add more chance of the occurrence of bugs or incompatibility between separate libraries.
    
* They have a higher risk of deprecation and breaking changes than standard library features.
    
* Relying on high levels of abstraction like frameworks makes your code, and possibly your knowledge and skills, non-transferable. In other words, you can't take what you learned in one framework and apply it directly in another.
    

Simply, the fewer dependencies you have in your project, the more robust and future-proof your project becomes. To be able to achieve this, you need the support of a rich standard library that allows you to do things with ease so that you don't need to reach for an external library.

## Data Structures

On the surface, the data structures I was exposed to so far are very similar in spirit (more on that in a bit) to those commonly used in JS. You get primitive data types like numbers, strings, and booleans, but one special data structure is the keyword which is most commonly used for "keys" in key-value pairs. For collections, you get vectors which are like JS arrays in the sense that they are ordered collections and can hold data that have different types, i.e., heterogenous. There are also hash maps which are like JS objects in the sense that they store key-value pairs.

I said that they are similar "in spirit" because these Clojure data structures are persistent (immutable), and that is a totally different behavior from JS where objects are mutable even when defined with the `const` keyword. Immutable data structures are one of the core features of functional programming, and I wrote an [article discussing some FP features](/posts/functional-programming.html) in a bit more detail if you're interested. So in that sense, the similarities lie mostly in their practical use and not the underlying data structure implementation.

On a final note, Clojure has more data structures I didn't mention like lists, hash sets, sorted sets (which I never used so far), and lazy sequences. What I like about the language's design here is that these data structures are categorized into abstractions like "sequences" and "collections," and that determines which functions you can use with them. I discussed this in a little more detail in contrast to the typical OOP approach in the same article linked above.

## Functions and Composition

The variety of functions provided by the core library (`clojure.core`) is the biggest reason for writing this article. A huge number of ways in which you would want to manipulate data are already implemented for you in standard library functions. This is great because most of your needs are already covered, and if not, they can be done by composing a small number of these functions. Note that I don't mean composing strictly as in "function composition" but rather the general idea of combining functions together. The result is code that is much more declarative than JS, and it's also more concise and clean (when you get over the parentheses).

Now let me share some examples of cool stuff I learned, I'll share some functions that I've got from exercises I solved in [4clojure](http://4clojure.oxal.org/) plus some functions and features I discovered outside of the context of a specific problem. They helped me discover and appreciate Clojure's standard library and how I can compose functions together to write declarative and concise code.

### Default Map

```clojure
(defn default-map
  [val keys]
  (zipmap keys (repeat val)))

(default-map 0 [:a :b :c]) ; {:a 0, :b 0, :c 0}
```

The task here was to make a function that takes a value and a vector of keys as its arguments, and its job is to construct a map where each key maps to this "default" value. Here's how the function works.

* `repeat` is a function that generates an infinite (lazy) sequence of the same value. In case you don't know, lazy sequences can be infinite because they only evaluate as needed, which will happen below.
    
* `zipmap` takes two sequences - one for keys and one for values - and constructs a map by associating the first key with the first value, the second key with the second value, etc.
    
* The advantage of combining the two is that `zipmap` will stop when it runs out with either keys or values. So, from the "infinite" values, Clojure will only get as many as the number of keys.
    

### Pack a Sequence

```clojure
(defn pack
  [seq]
  (partition-by identity seq))

(pack [1 1 1 2 3 3 4]) ; ((1 1 1) (2) (3 3) (4))
```

This code is meant to take a sequence and "pack" each set of consecutive duplicates into a separate sequence. Thankfully, there is a function called `partition-by` which, as the name indicates, partitions sequences by something. That "something" should be a function, and here we supply `identity` which means we partition by values whose identities (the values themselves) are equal to each other. There's also another function called `partition` which splits a sequence based on a fixed number of elements.

### Dot Product

```clojure
(defn dot-product
  [c1 c2]
  (apply + (map * c1 c2)))

(dot-product [1 2 3] [0 10 100]) ; 320
```

As per Wikipedia, *"Algebraically, the dot product is the sum of the products of the corresponding entries of the two sequences of numbers."* So the code works like this:

* `(map * c1 c2)` takes the two collections and applies the multiplication function on each pair, returning the vector `[0, 20, 300]`.
    
* `apply` is similar to the spread (`...`) operator in JS where you supply a collection and its elements are supplied as arguments. So, `+` in the example takes 3 arguments: 0, 20, and 300 (instead of the whole vector as a single argument).
    

I have a lot more examples like these to share, but I don't want to do too much cherry-picking of all the cool one-liners that I wrote or found online.

### Other Conveniences

There are other functions and conveniences that I learned about and find to be quite nice to help perform common tasks with a small amount of code.

* Maps can be called as functions for lookup, so `({:a 1 :b 2} :a)` will return 1. Also, keywords can be called as lookup functions, so `(:a {:a 1 :b 2})` also works.
    
* Sets can be called as predicates, so `(filter #{1 2} [2 5 4 3 9])` looks for 1 or 2 in the vector, returning the list `(2)`.
    
* `complement` can be called on a predicate (a function that returns a boolean) and returns the "complement" function which returns the opposite boolean.
    
* There is a concise syntax for anonymous functions. For example, `#(map * %1 %2)` is an anonymous function that calls `map` to apply the multiplication function on two arguments (you see, `%1` and `%2` specify the arguments at which positions without having to name them.) Notice that `map` here accepts whatever number of arguments that work for the function, which is convenient.
    
* Arithmetic and comparison functions can take arbitrary numbers of arguments, so the plus can act as a sum, and the greater-than/less-than functions work on the arguments consecutively, so `(<= 1 2 2 4)` returns `true`.
    
* Threading macros are a convenient way to pipe the output of one function into the next one as an argument, so the code can be read top-to-bottom instead of the nested syntax. For example, here is a refactor of the `default-map` function above to use the threading macro `->>` which piped an output as the last argument in the next function.
    

```clojure
(defn default-map
  [val keys]
  (->> val
       repeat
       (zipmap keys)))
```

The language is full of cool stuff like this. So, there is so much you can do without having to reach out to a library when it comes to handling and manipulating data. In JavaScript, I would've had to make a custom function and pass it to `array.map()` or `array.reduce()`, and then things get too complex so I split it into multiple `map`/`reduce` calls and create some intermediate arrays. When you compare this approach to Clojure's, it feels wasteful, especially when the code becomes more verbose and imperative and you have to re-read the whole thing if you want to check how that particular step works.

You may argue against Clojure because it's too dense and you have function names in front of you that you don't know what each one does. First, with practice, these little idioms become easy to understand - Difficulty is simply a matter of unfamiliarity in most situations. Also, and most importantly, Clojure is a very well-documented language. [https://clojuredocs.org/](https://clojuredocs.org/) is a community-powered site with good examples and it's my favorite source of documentation. These documentation pages are also accessible from my editor thanks to [Clojure LSP](https://clojure-lsp.io/), which is even more convenient.

![interleave clojuredocs](https://i.imgur.com/f0HGnxH.png)

![interleave lsp](https://i.imgur.com/5Yrw2z8.png)

## There's More

There always is! This article was mainly concerned with a small subset of `clojure.core` functions whose main job is to manipulate data. There is a whole world of stuff related to concurrent programming and mutable state that I am still learning at the moment, and that should be interesting to compare and contrast with JavaScript's concurrency model.
