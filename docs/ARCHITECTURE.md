# Klock Architecture Guide

## Core Architecture Principles

### 1. Custom Engine Pattern
We're building our own animation and time management systems to understand:
- How animation frameworks work internally
- Time interpolation and easing functions
- Frame scheduling and performance optimization

### 2. Component-Based Design
- **ClockFace**: Handles background, markers, numbers
- **ClockHands**: Individual hand drawing and animation
- **TimeEngine**: Manages time state and updates
- **AnimationEngine**: Handles smooth transitions

### 3. Separation of Concerns
- **Time Logic**: Pure time calculations
- **Rendering**: Visual representation
- **Animation**: Motion and transitions
- **State Management**: Current clock state