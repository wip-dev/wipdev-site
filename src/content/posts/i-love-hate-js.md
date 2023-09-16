# I Love/Hate JavaScript

![cover](https://cdn.hashnode.com/res/hashnode/image/upload/v1690546152695/cfb3a1f2-c1eb-472b-b246-ee7d89dc5d24.avif?w=1600&h=840&fit=crop&crop=entropy&auto=compress,format&format=webp)

Today's overthinking rant is about none other than JavaScript: *THE* programming language of all modern browsers, plus some servers as well thanks to runtimes like Node. The one that pushed the web so hard and so far it's practically everywhere now.

I do appreciate JS for what it did for the web, but from time to time, I just can't! So, let's talk about it...

## I Love JavaScript

The introduction should let you know I'm aware of how undeniably powerful and pervasive JS is these days. Any JS beginner tutorial will tell you that JS adds dynamic behavior to static websites, but it grew so much beyond that, and now it has a gigantic ecosystem of libraries and frameworks I can't even begin to describe.

Personally, I wasn't even a web developer. I was learning data science on R, but I gradually discovered web technologies used for data science inside and outside of R. *That* is how pervasive the web is. (I wrote [an article about my introduction to the web](https://wipdev.netlify.app/posts/what-got-me-here) if you're interested.) In a way, the web has indirectly given me cool tools for data science and helped me with my biostatistics career.

An important point directly related to its popularity is the huge community around it. It goes without saying, but think about the sheer amount of JS content, educational or otherwise, being put online as videos, courses, articles, or podcasts. Not to mention communities on Slack or Discord... Thousands of people learning, building software, and making careers out of JS.

Then there are the people who develop packages, frameworks, or JS itself. I mean, we all get the jokes about a new JS framework coming out every couple of days, but in the middle of this mess, there are people genuinely trying to improve the web and make our jobs easier. The language itself did get improved over time, with ES6 being a notable example, and frameworks also are constantly getting better.

Still, though...

## I Hate JavaScript

%[https://twitter.com/fireship_dev/status/1684324664699674625] 

We all saw some form of that (multiple times, I bet). Also, I read somewhere that the language was built in 10 days, which I find believable. Every time that kind of talk about JS comes up in front of me, the same feeling resurfaces - the feeling that I'm working with a hacky language. Even an elegant framework on top will still require me to use that hacky language, just to a lesser extent than going completely vanilla.

The package/framework ecosystem is rich, no doubt, but the language itself isn't. It does have all the basics of any programming language, and it does have a good set of features for DOM manipulation, HTTP requests, and other web APIs, but that's pretty much it. There are lots of relatively simple things that you have to do by grabbing a package or making your own implementation.

I don't expect a modern language to have me write everything from scratch unless it has a standard library that is rich, reliable, and not full of footguns. Also, I get an itch whenever I have to `npm install` something (and it hurts so much that I would [rant about it in a dedicated article](https://wipdev.netlify.app/posts/dependencyphobia)). To make it clear, here is my order of preference:

**Language built-in &gt; framework built-in &gt; external package**

## What to Do About It

If you don't like JS, you could either accept that you have to deal with it or just avoid anything that says "client-side" like the plague. The backend has multiple languages for you to pick. You could also leave the web altogether, not all code runs on the web.

There is another option, but I wouldn't recommend it yet as it's currently very niche and I'm still trying it out... And that is ClojureScript. I don't know if something like it exists, but it's simply a language that compiles to JS. At the time of writing this article, I've been trying ClojureScript for about a week. All I know is that it has an ecosystem of frontend build tools and libraries for making React components. Its selling point is that it combines the functional programming paradigm with fast and interactive development. I have yet to test that myself, but I'll gradually learn and share about it in the blog.

## Conclusion

That ends my rant about the love/hate relationship I have with JS. Please feel free to share your thoughts, especially if you think I'm wrong. I would appreciate other perspectives. Thanks for reading!
