# Klock Architecture Guide

## Core Architecture Principles

### 1. Custom Engine Pattern
We're building our own animation and time management systems to understand:
- How animation frameworks work internally
- Time interpolation and easing functions
- Frame scheduling and performance optimization

### 2. Theme-First Design
- **Material3 Foundation**: Built upon modern Material Design
- **Custom Extensions**: Clock-specific design tokens
- **CompositionLocal**: Theme propagation through UI tree
- **Semantic Colors**: Purpose-based naming for maintainability

### 3. Component-Based Design
- **ClockFace**: Handles background, markers, numbers with theme support
- **ClockHands**: Individual hand drawing and animation with themed styles
- **TimeEngine**: Manages time state and updates
- **AnimationEngine**: Handles smooth transitions with custom easing

### 4. Separation of Concerns
- **Time Logic**: Pure time calculations
- **Rendering**: Visual representation
- **Animation**: Motion and transitions
- **State Management**: Current clock state
- **Theming**: Design tokens and styling

## Package Architecture

### Package Structure

```
ui/
├── theme/ # Design system foundation
│ ├── Color.kt # Color palettes and tokens
│ ├── Type.kt # Typography system
│ ├── Shape.kt # Shape definitions
│ ├── Theme.kt # Main theme composable
│ ├── ThemePreview.kt # Theme testing and previews
│ └── state/ # Theme state management
│ └── ThemeState.kt
├── components/ # Reusable UI components
│ ├── ThemeSwitcher.kt # Theme control components
│ └── (future clock components)
└── screens/ # App screens and main UI
└── MainActivity.kt
```

### Architecture Benefits
- **Cohesive UI Package**: All visual elements in one logical structure
- **Clear Separation**: Theme system vs components vs screens
- **State Isolation**: Theme state managed separately from domain state
- **Scalable Structure**: Easy to add new components and features

### Key Architectural Decisions

#### 1. Theme System Organization
- **theme/**: Pure design tokens and theming logic
- **theme/state/**: Theme-specific state management
- **components/**: Theme-aware UI components including ThemeSwitcher

#### 2. State Management Strategy
- Theme state is UI-specific and belongs in ui/theme/state/
- Future time state will be in engine/ or time/ packages
- Clear boundaries between UI state and domain state