# 🕰️ Klock - Custom Analog Clock for Android

> An educational Android analog clock app built with Kotlin & Jetpack Compose, featuring a custom animation engine and time management system.

Click [here](docs/IMPLEMENTATION_STATUS.md) to see the implementation status.

## 🎯 Learning Objectives

- **Custom Drawing**: Master Canvas and custom drawing in Jetpack Compose
- **Animation Systems**: Build a custom animation engine from scratch
- **Time Management**: Implement sophisticated time handling and interpolation
- **Architecture**: Practice clean architecture with custom engines
- **Performance**: Optimize real-time animations and rendering
- **Theming**: Build a comprehensive design system with Material3
- **Mathematical Foundations**: Understand trigonometric clock calculations

## 🚀 Features

- **Theme System**: Material3 with light/dark theme switching
- **Clock Face**: Custom drawing with markers, numbers, and backgrounds
- **Clock Hands**: Configurable hand styles with rotation system
- **Mathematical Foundation**: Trigonometric calculations for circular positioning

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose with Material3
- **Animation**: Custom Compose animation engine
- **Architecture**: Custom engine pattern with theming system
- **Drawing**: Compose Canvas with custom mathematical layouts
- **Tools**: Android Studio, Gradle Kotlin DSL

## 📚 Documentation

- [Architecture Guide](docs/ARCHITECTURE.md) - Understanding the custom engines and package structure
- [Learning Journey](docs/LEARNING.md) - Educational notes and concepts
- [Development Guide](docs/DEVELOPMENT.md) - Getting started and project setup
- [Theming System](docs/THEMING.md) - Design system and theme architecture
- [Package Structure](docs/PACKAGE_STRUCTURE.md) - Detailed package organization

## 🏗️ Project Structure

```
app/src/main/java/com/yourname/klock/
├── ui/ # User Interface Layer
│ ├── theme/ # Design System & Theming
│ │ ├── Color.kt # Color palettes (light/dark)
│ │ ├── Type.kt # Typography system
│ │ ├── Shape.kt # Shape definitions
│ │ ├── Theme.kt # Main theme composable
│ │ ├── ThemePreview.kt # Theme testing & previews
│ │ └── state/ # Theme State Management
│ │ └── ThemeState.kt # Theme mode state
│ ├── components/ # Reusable UI Components
│ │ ├── clock/ # Clock-specific components
│ │ │ ├── ClockFace.kt # Clock face with markers
│ │ │ └── ClockHand.kt # Individual clock hands
│ │ └── ThemeSwitcher.kt # Theme control components
│ ├── models/ # UI Data Models
│ │ └── ClockModels.kt # Clock data structures
│ └── screens/ # App Screens & Layouts
│ └── MainActivity.kt # Main app screen
├── engine/ # Custom Clock Engines (Future)
├── animation/ # Animation System (Future)
└── time/ # Time Management (Future)
```

## 🎓 Educational Focus

This project emphasizes understanding **how** things work rather than just making them work. Each component is built with learning in mind:

- **Mathematical Foundations**: Trigonometric calculations for clock positioning
- **Type Safety**: Kotlin value classes and sealed classes for robust data modeling
- **Custom Drawing**: Low-level Canvas operations with mathematical transformations
- **Reactive Architecture**: Compose state management and theme switching
- **Performance Optimization**: Efficient drawing and animation techniques

## 🔧 Getting Started

1. Clone the repository
2. Open in Android Studio Hedgehog or later
3. Sync project on emulator or device
4. Explore the theme system and clock components

See [DEVELOPMENT.md](docs/DEVELOPMENT.md) for detailed setup instructions.

## 🏗️ Core Components

### Theme System
- Material3-based design tokens
- Light/dark theme switching
- Custom color palettes for clock elements
- CompositionLocal for theme state propagation

### Clock Face
- Custom Canvas drawing with mathematical positioning
- Configurable markers and numbers
- Theme-aware colors and styles
- Responsive sizing and scaling

### Clock Hands
- Configurable styles (length, width, color, caps)
- Mathematical rotation system
- Support for hand tails and different cap styles
- Efficient drawing with transformation matrices

## 🤝 Contributing

This is an educational project focused on learning Android development concepts. Feel free to:
- Study the code and learn from the implementation
- Experiment with different clock designs and animations
- Extend the theme system with new color schemes
- Implement additional clock features and configurations

## 📝 License

This project is open source for educational purpose.