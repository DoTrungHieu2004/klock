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