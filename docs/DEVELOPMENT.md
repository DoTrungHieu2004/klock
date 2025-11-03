# Klock Development Guide

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Android SDK 34_
- Kotlin 1.9.0+

### Project Setup
1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Build and run on emulator or device

### Project Structure
```
app/src/main/java/com/yourname/klock/
├── engine/ # Custom time & animation engines
├── components/ # Clock hands, face, markers
├── animation/ # Custom animation system
├── time/ # Time management and interpolation
└── ui/ # Compose screens and previews
```

## 🏗️ Development Approach

### Phase 1: Foundation ✅
- [x] Project setup and structure
- [x] Material3 theming system
- [x] Basic composable architecture

### Phase 2: Core Clock
- [ ] Time engine and state management
- [ ] Basic clock face with static hands
- [ ] Canvas drawing system

### Phase 3: Animation Engine
- [ ] Custom animation scheduler
- [ ] Hand interpolation system
- [ ] Smooth motion effects

### Phase 4: Advanced Features
- [ ] Multiple clock styles
- [ ] Timezone support
- [ ] Performance optimization

## 🎯 Code Standards

### Kotlin Conventions
- Use descriptive names for variables and functions
- Prefer `val` over `var` when possible
- Use extension functions for utility operations
- Follow Kotlin coding conventions

### Compose Guidelines
- Use `remember` for state that survives recomposition
- Prefer `LaunchedEffect` for coroutines in composables
- Use `Modifier` consistently for styling
- Follow unidirectional data flow

### Architecture Patterns
- Separate business logic from UI
- Use state hoisting for reusable components
- Keep composables focused and testable
- Document custom engines thoroughly

## 🔧 Building and Testing

### Running the App
```bash
./gradlew app:assembleDebug
./gradlew app:installDebug
```

### Running Tests
```bash
./gradlew test
./gradlew connectedAndroidTest
```

### Static Analysis
```bash
./gradlew ktlintCheck
./gradlew detekt
```

## 📝 Commit Convention

We follow conventional commits:
- `feat`: New features
- `fix`: Bug fixes
- `docs`: Documentation updates
- `style`: Code style changes
- `refractor`: Code refactoring
- `test`: Test additions/modifications
- `chore`: Maintenance tasks

## 🐛 Debugging Tips

### Custom Engine Debugging
- Use `Log.d()` in animation loops
- Add debug overlays for hand positions
- Profile frame rates with JankStats

### Compose Debugging
- Use Layout Inspector
- Enable compose compiler reports
- Check recomposition counts

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Follow code standards
4. Add tests for new features
5. Submit a pull request

## 📚 Learning Resources

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material3 Theming](https://m3.material.io/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-guide.html)
- [Canvas Drawing](https://developer.android.com/develop/ui/compose/graphics/draw/overview)