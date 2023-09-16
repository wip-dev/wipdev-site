# React Rant (+ Should I Be a Backend Dev?)

![cover](https://i.imgur.com/QAk0myx.png)

I've been writing frontend code for a long while, but most of it was relatively shallow in the grand scheme of things - mostly static sites. Only very recently, I got to develop something that qualifies as a SPA with React (using Vite). I used TailwindCSS and DaisyUI for the UI. The app logic included client-side routing with React Router, interacting with backend APIs using Fetch, handling JWTs and state management using the Context API.

Developing that app hit me with an existential crisis that made me question React and the whole frontend ecosystem! So, I'll discuss my issues with React here and what I'll do about it (which the title already gave away).

## Credit Where It's Due

I want to be clear about it. I don't think React is *bad* per se. While I didn't experience it first-hand, I am still aware that React did to the web what jQuery did at one point in time. React shaped modern frontend development, no argument about it, and even new frameworks are using React's model as the baseline upon which they add modifications.

The good doesn't absolve the bad for me, though. It's still causing me a lot of pain in terms of developer experience.

## My Gripes with React

I'm not the only or the first one to complain about React. With all the frameworks coming out nowadays, it's hot to complain about React right now. However, I'll discuss my view based on personal experience.

### Libraries for Everything

I have a serious [dependencyphobia](https://wipdev.netlify.app/posts/dependencyphobia), and I can't fight it anymore. I actively strive to use as few libraries as possible in my code. React works the exact opposite way. It's hard to try to do something in React without one or more `npm install`s. It's even recommended to use libraries instead of standard web stuff: React Query instead of Fetch, Formik instead of HTML forms, etc.

There's an icky feeling that constantly accompanies me as I learn React and end up with a library recommendation instead of learning about the actual web APIs on MDN. I'm sure the libraries will probably be easier to use, but I don't want to be learning library-specific workflows all the time. If you develop only in React for so many years, chances are you're good *only* at React and React libraries, not JavaScript, not the web. That's simply not something I aspire to be.

### Wrap, Nest, Indent

One thing I don't like in any code I write is excessive nesting, and React is excruciating in that regard. JSX only accepts a single element, so use either a parent `<div>` or the fragment syntax `<>` to return multiple sibling elements - a completely unnecessary level of indentation. Since React is all about the motto "It's just JavaScript," it lets you `map` over an array inside your JSX to return some JSX children which, just like the parent, must be contained in a single pair of tags and must be wrapped with curly braces if it's an explicit return in the function passed to `map`... \*sigh\*

This is the average component that I (and many frontend devs) write. 6 levels of nesting away from the top level, and like half of it is boilerplate! Not to mention that the parentheses and curly braces inside the `map` code trip me up on multiple occasions when editing code that was already written.

```plaintext
export default function MyComponent() {
    ... 

    return (
        <>
            <div className="...">
                <div className="...">
                    {array.map((d, i) => (
                        ...
                    ))}
                    ...
                </div>

                ...
            </div>

            {data && (
                ...
            )}
        </>
    );
}
```

Another source of nesting is using libraries that require you to wrap your components, or the whole app, in component tags to provide routing, state management, etc. I never thought that going declarative could have disadvantages until I got exposed to those crazy levels of nesting. The HTML-like syntax is getting terribly overused.

You could argue that nesting could be minimized by multiple techniques, but I'll say that no single technique is useful. Compressing a multi-line function into a single line or omitting curly braces for implicit return will hurt readability unless the function is really short. Abstracting the deeply nested JSX elements into their own components simply replaces one problem with another - instead of trying to keep track of what element goes inside what element, now I need to keep track of what component goes into what file. Even fuzzy finders (like Ctrl+P on VSCode or Telescope on Neovim) and jump-to-definition can only take you so far.

### The "Unopinionated" Illusion

I hope this is not the first time you hear about React being "opinionated" or "a framework."

> "*Actually, React is a library.*"

But the way we talk about and use React in our day-to-day setting makes it, without a doubt, a framework! When you start a React project, you use some CLI to get "React The Library" plus a lot of stuff including a build tool/module bundler, JSX (which isn't part of "React The Library" but 99% of React devs use), a transpiler for converting the JSX into JS, and probably some other stuff I don't even know. All that stuff is installed for you, plus a code template organized in a pre-determined way. If that's not a framework, I don't know what is.

If you get React and ReactDOM as CDN links, paste them in the `<head>` tag of an HTML page and use `React.createElement()` directly, then you may call it a library.

Now let's talk about it being opinionated. People like to say it's unopinionated because it provides a low-level system of components and hooks to do your frontend development. What they never say, though, is that there is a "React Way" of doing everything, and you have to obey it when you write your code in this "unopinionated" framework. What annoys me is that I have to unlearn some programming concepts that I already know from elsewhere because they break under the React rendering model.

## Alternatives

If I'm annoyed by React so much, what can I do? Right now I can think of two ways to go forward...

### Alternative 1: SvelteKit

The first way is to go with SvelteKit as the framework of choice, especially with TypeScript. The serverless architecture that SvelteKit supports treats a lot of SPA issues that are widely recognized. Svelte, in particular, directly addresses all the issues I have with React thanks to:

* A great collection of built-in features that minimize the need for third-party dependencies
    
* Emphasis on the direct use of web standards and APIs (get actual web knowledge instead of framework-specific stuff)
    
* Clean and minimal code with very little nesting required on top of the markup
    
* Being opinionated/magical where it matters
    

Do I like this approach? For the most part, yes. I tried SvelteKit for some time and developed a full project with it for work. As far as JS/TS goes, this could be my best stack and I will use it in any upcoming projects if I get the chance.

### Alternative 2: Backend

But how does backend development factor in here? The answer lies in re-examining the big picture, the whole reason the React (and general SPA) ecosystem exists is to improve the user experience by providing interactive UIs and minimizing or eliminating the need for page reloads. The serverless approach does it by putting the JS logic into functions that do SSR, while this approach optimizes the backend to handle data and serve HTML faster. While the two approaches cannot completely replace each other, most applications I worked on are suitable candidates for being completely backend-centered while sprinkling JS only where it's needed.

I don't know how to describe it, but when I went this deep into React (which is not very deep for some), I started getting the feeling that I was developing a backend for the frontend: storing and managing data, keeping track of authentication, etc. This doesn't feel right to me. I don't know why, maybe that's just me being a boomer, but maybe these backend-like tasks belong on the backend? I believe the point of view makes sense because that's what serverless technology is trying to do - bring back server-side rendering.

This approach now feels like the "right" way to do things because I like the idea of having the server as the single source of truth and the central point of data processing and state management. The SPA model put too much of the app functionality on the client side in my humble opinion.

### Alternative 2.5: HTMX

HTMX is so hot right now, and many are finding it a great alternative to frontend frameworks in their applications. I don't know a lot of details about it, but I think I have a general idea of how it works. Using HTMX means the emphasis is still on the backend, but the JS code loaded by HTMX now handles UI changes that happen when HTTP requests are sent/received. It's the best of both worlds: the declarative code and interactivity without reloading while still being backend-centered.

## What to Do?

Considering the alternatives I described, I already tried the first one and was mostly satisfied with it. However, I usually like to explore most options I have before sticking with one. So, this means I'll try backend development and see what happens there for a while before deciding what I'll choose for my projects in the near future.

What language will I use for backend development? It may not be a popular choice by any means, but I will choose Clojure for now. I have been learning Clojure for nearly two months, and I like it a lot. It's a functional Lisp that maintains some level of pragmatism by being dynamically typed, not fully pure (unlike Haskell), and sitting on top of the Java ecosystem. I have a lot to learn about FP and Clojure, but I'm having fun so far. If it doesn't pan out eventually, I can bounce back to SvelteKit.
