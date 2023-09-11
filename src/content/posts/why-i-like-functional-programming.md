# Why I Like Functional Programming

![cover](https://i.imgur.com/UBKVaYj.png)

I've been gravitating towards functional programming for years, and the basic functional features in languages like JavaScript or R don't feel enough for me. I always wanted to go deeper into that route, and (at the time of writing this) I am trying to learn Clojure to satisfy that curiosity.

"But why am I going so far into FP and its obscure languages?" I keep asking myself, and I can't find complete answers yet. Is it me just being a contrarian because functional languages are less common? Did my first language bias my thinking towards FP? Or... does the imperative/object-oriented paradigms truly make less sense?

In the next few sections, I put down some thoughts for you and myself to try to answer the question.

## Functions Before Programming

What I like about functions is that they are such a universal concept. I learned about functions before I even started programming. I encountered functions in the mathematical sense in school, with the domain (X) and codomain (Y) and how it assigns for each value of X a single value in Y. I can't say I understood what it all meant back then. But looking in retrospect after studying statistics and programming, the concept of the function is pervasive in both fields.

Now, I am still interested in studying more about functions from a mathematical perspective, and I believe calculus is where I should go to learn about them. I once watched the first 3-4 lectures of an introductory calculus course on YouTube, and the lectures were completely focused on explaining functions and their properties. I didn't have the time to keep going back then, but I was fascinated by what I watched.

## FP-Like Experience in R

My programming journey started with R. It is not a functional language per se, but the way you write code in R overlaps greatly with the FP philosophy. Here are a bunch of similarities from my perspective:

1. In practical situations (writing code for data science) you rarely, if ever, write classes or methods. What I think is elegant in R is that it is technically an OO language with built-in classes and methods, but **everything looks like function calls**. I'm sure the purpose of this was to simplify programming for statisticians. But I still find this approach elegant to this day, which draws me to the FP paradigm.
    
2. Most R code, especially in the very popular Tidyverse packages, has **no form of mutation**. You call a function on the data, which returns a copy of the (now modified) data, and you pipe that into another function, and so on. I only started learning OOP and the concept of mutation when I shifted to Python, and it caused me a lot of confusion (more on that later).
    
3. **Higher-order functions** are commonly used in practice. The R standard library even has its implementation of the known functions (`map`, `reduce`, etc.). The documentation of these functions even refers to Haskell and Common Lisp.
    
4. Given all the points above, you can simply have your R project operate on the data with **minimal side effects**. Ideally, an R script would have no side effects except for the parts where it reads data or generates graphics, reports, etc.
    

I've developed this analysis of the R language retrospectively because I didn't exactly know these characteristics until I learned more FP in other languages

## FP Really Clicked

At some point, my curiosity got me to try some "computer science" kind of courses. So, I checked out [this roadmap](https://github.com/ossu/computer-science) and took the first 4 courses. The first was an intro to Python with basic OOP principles. The other 3 were *heavily* functional - one of them used [Standard ML](https://en.wikipedia.org/wiki/Standard_ML) and the other two used [Racket](https://en.wikipedia.org/wiki/Racket_(programming_language)). In all courses, the concepts clicked so much with me, and I was able to grok many of them with enough practice. I especially remember doing a lot of recursion exercises and some good practice with the popular high-order functions `map`, `filter`, etc.

A couple of years passed by, and here I am learning Clojure and still growing to appreciate FP (and now Lisp) even more! The language's standard library is rich with various functions and clever language features that allow you to do so much with so few lines of code, and with so simple data structures.

## OOP Never Clicked

I learned some basic OOP in both Python and R. Up to this day, I find no reason to represent day-to-day data manipulated by developers as classes. You tell me I should make a `Dog` class and a `Cat` class, make getter and setter functions, and have them inherit properties or methods from an `Animal` class. This already feels overly complicated to me, and I didn't even get into Clean Code or the "Gang of Four" Design Patterns.

Why go through all that effort to make a hierarchy of abstractions to describe some models of data when you can use the data directly? Most (or all) of the time, development is about getting data from somewhere, performing some operations on it, and making some effect(s) based on the output of these operations. Such workflow, I believe, is completely feasible with functions and simple data structures like collections and key-value pairs. There are definitely some advanced concepts in FP, and maybe it could be *harder* than OOP, but it is *simpler* which I appreciate.

Maybe I'm biased because my programming foundation was more functional than object-oriented. But if OOP is so easy and intuitive, then why are we moving away from it? Most of the modern web development I see now is free from writing classes, except in some backend frameworks where you extend the framework's classes for models, views, etc., and to me that counts as "using the framework" more than "doing OOP." JS's functional features introduced in ES6 are very commonly used now. React moved from classes to functions. You get the idea.

## Conclusion

One of the definitions of the word "paradigm" that I find appropriate for this discussion is

> "a world view underlying the theories and methodology of a particular scientific subject."

We all view the world differently, whether it's generally or in programming. I could say that after almost six years of learning to code, the functional "worldview" is the one that (so far) makes the most sense to me. If you care, I encourage you to explore and try different paradigms and languages and develop your own view.
