# Klock Theming System - Educational Guide

## 🎨 Design System Philosophy

### Why a Custom Theme System?
- **Consistency**: Ensures visual harmony across all components
- **Maintainability**: Centralized design tokens make updates easy
- **Scalability**: Easy to add dark mode, new color schemes, etc.
- **Brand Identity**: Creates a unique look for Klock

## 🏗️ Architecture Overview

### 1. MaterialTheme Foundation
We build upon Android's MaterialTheme for:
- Standardized design tokens
- Built-in accessibility features
- Consistent spacing and sizing

### 2. Custom Extensions
We extend MaterialTheme with:
- `KlockTypography`: Clock-specific text styles
- Custom color tokens for clock hands and markers
- Specialized shapes for clock components

### 3. CompositionLocal Pattern
Using `CompositionLocalProvider` to inject our custom theme properties that are available throughout the composition tree.

## 🎯 Key Learning Points

### Color System
- **Semantic Naming**: Colors are named by purpose, not hue
- **Accessibility**: Sufficient contrast ratios for readability
- **Theme Consistency**: Light/dark variants maintain relationships

### Typography Scale
- **Modular Scale**: Font sizes follow mathematical ratios
- **Hierarchy**: Clear visual distinction between text roles
- **Readability**: Optimized line heights and letter spacing

### Shape System
- **Progressive Radii**: Consistent corner rounding across sizes
- **Visual Weight**: Shapes help establish component importance
- **Brand Identity**: Unique shapes create memorable design

## 🔧 Implementation Patterns

### Theme Access
```kotlin
// Material theme colors
MaterialTheme.colorScheme.primary

// Custom Klock theme properties
MaterialTheme.klockTypography.clockDisplay
```

### Theme Customization
The structure makes it easy to:
- Add new color schemes
- Create component-specific styles
- Support user theme preferences