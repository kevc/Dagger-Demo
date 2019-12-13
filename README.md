# Dagger-Demo

![Diagram](https://github.com/kevc/Dagger-Demo/blob/master/daggerdemo.png)

## Overview

This repository exists to demonstrate one way to keep Dagger Components for a given feature module in that feature module. There were a number of corners cut in order to save time. Since this is only to demonstrate one particular Dagger implementation, it does not represent most of my favored development approaches/tools/styles.

As for what the application actually _does_...it is a single Activity with two tabs. One displays neverending random numbers, and the other displays neverending random strings (generated UUIDs).

## Implementation

### Feature Fragment setup

Each tab in the Activity is populated with a Fragment. Each Fragment is housed in its own feature module (`randomint` and `randomuuid`). Each Fragment has a ViewModel, which is provided via a `ViewModel.Factory` implementation. The ViewModels' factories are `@Inject`-ed.

### Feature Components

These factories, along with their upstream dependencies, are provided via Dagger. Specifically, each feature module has its own Component.

Some dependencies are scoped to the feature modules, so they can be provided in a straightforward manner. I explicitly chose to set this up such that there were dependencies scoped to the *AppScope*, housed in `AppComponent`. For feature components to inject app-scoped dependencies, we needed a "bridge" component that *app* module and the feature modules could access: `MainComponent`

`MainComponent` is a Subcomponent of `AppComponent`, and can be accessed through this helpful extension function:

```
fun Fragment.getMainComponent(): MainComponent {
    return (requireActivity().application as RootComponent).appComponent.mainComponent
}
```

Our `App` class implements `RootComponent`, which provides access to `IAppComponent` (as implemented by the _real_ `AppComponent`), thus providing access to `MainComponent` from any feature.
