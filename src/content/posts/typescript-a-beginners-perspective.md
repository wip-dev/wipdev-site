# TypeScript: a Beginner's Perspective

![cover](https://cdn.hashnode.com/res/hashnode/image/upload/v1692954785301/fd5257fb-435a-4561-b1d1-a614b2530635.png?w=1600&h=840&fit=crop&crop=entropy&auto=compress,format&format=webp)

I've been writing JavaScript for quite some time now, but most of it was powering static sites. I started working on actual frontend apps with state management, routes, auth, and API calls very recently. Using JS on its own became increasingly harder for me even within the constraints of a framework. The combination of the frontend having so many moving parts and JS being overly flexible is dangerous. It allows me to do too many things that can break when running on the browser.

So, I got attracted to the idea of using TypeScript. I tried it in a SvelteKit project I did for work as an experiment, then another project in React. My experience so far is on the positive side even though I struggled a bit with the compiler errors. I'll talk about my perspective here in the hope that I convince you to get into TS as well. I don't care what your JS experience level is - as long as you use a JS framework, I believe TS would be a great addition to your stack.

To set the context, let me describe the way I use TS. As a beginner, I know I am not using it to its full potential. I mostly write plain JS code until I am prompted to do something else, which is usually due to an implicit `any` or a potential `null` without a proper check. But sometimes, I proactively write types for some objects to specify their properties and which of those are optional, some union types with constants for a variable that I know will take specific values (e.g., `let category: "A" | "B" = "A";`). Nothing too fancy.

So, with that said, let us explore why you should use TS even as a beginner.

## Same Setup Process

If you're starting up a project, adding TypeScript is as simple as choosing a template. As far as I know, all the big frameworks and build tools out there support adding TS in the project boilerplate. I did it with React (with Vite) and with SvelteKit, and I know Create React App has a TS template as well. TS is so popular right now it's hard not to support it.

If you are adding TS to an already existing project, it might be less straightforward. It's not super hard, but you would have to install some libraries, add new configs, and modify existing files like `package.json`. One way I like to do it is to start a new empty project with the TS template (for the same framework you are using) and then copy the configs from there. It worked for me on the occasions I needed it.

## Escape Hatches

You need to invest some amount of time and effort to learn and use TS, but it barely feels like a risk to take at all. This is because you could always bypass the compiler errors in multiple ways. The compiler is configurable so that you can...

* Make it less strict (`"strict" = true` in `tsconfig.json`)
    
* Specify object types as `any`
    
* Ignore particular errors in the source code (`// @ts-ignore`)
    
* Leave the errors and just compile to JS anyway
    

This is by no means permission for you to go and bypass most of TS's functionality - that would defeat the whole purpose. But still, this is a way in which you can bypass TS as much as you need while incrementally adding it to your codebase without having to worry about any potential breakage.

## Better DX

TS gives you handy features for better DX (developer experience). The most popular is smarter completion. If you specify the types of your variables, autocomplete can suggest the property names or possible values for that variable. That also works for other stuff like DOM nodes and event handlers. TS also has type inference which means (1) you don't have to specify types for everything, and (2) the compiler, and you as its user, can better reason about code that you write or use from a library.

What I like most about TS is a direct consequence of what I described above. When I interact with TS, it shows me how bad I am as a JS developer. It points out my mistakes at the time of writing them, and it tells me how to fix them most of the time. That, for me, counts as a huge plus to DX because it increases my confidence in the code I write, especially as I go into projects outside my comfort zone.

To be completely fair, the extra code you add on top of JS might not feel like a DX improvement to some people. DX is a largely subjective thing, especially with respect to syntax. I don't mind the syntax at all, and the language features I get are too valuable to sacrifice for having shorter code.

## Better UX

How does that tie into UX? Well, with all these features, you end up squashing a significant number of bugs before you even go to the browser. So, there are two results of that. Having fewer bugs in general obviously means a smoother UX. Also, detecting them in your editor gives you a much shorter feedback loop as you iteratively develop your app and fix bugs along the way, and that means you can ship and update your software faster. Users will surely be happy about that.

Of course, TS code is not meant to be completely bug-free, but it will be at least free of a lot of the common bugs that are caused by JS dynamic behavior or lack of static analysis. Also, TS itself is not the core of UX improvement, but it's definitely a step in the right direction.

## Conclusion

I truly consider TS one of the greatest things that happened to the chaotic world of frontend web development. It helps you write better code faster, and there is near-zero risk associated with adding it to your stack. I hope you found this article informative and encouraging for you to try TS if you haven't already.

* * *

Cover image source: [https://www.educative.io/blog/typescript-tutorial](https://www.educative.io/blog/typescript-tutorial)
