# 🍽️ Retrofit with Jetpack Compose

A clean Android project demonstrating how to fetch and display data from a REST API using **Retrofit** + **Jetpack Compose** following **MVVM architecture**.

---

## 📸 Features

- ✅ Fetch meal categories from [TheMealDB API](https://www.themealdb.com/api.php)
- ✅ Display categories in a scrollable list with images
- ✅ Loading / Success / Error states using `UiState`
- ✅ Retry on failure with Snackbar
- ✅ Image loading with Coil
- ✅ Clean MVVM architecture

---

## 🏗️ Project Structure

```
app/
├── data/
│   ├── model/          → Category.kt
│   ├── network/        → ApiService.kt, RetrofitClient.kt
│   └── repository/     → CategoryRepository.kt
├── util/               → UiState.kt
├── viewmodel/          → CategoryViewModel.kt
└── ui/
    ├── components/     → CategoryCard, CategoryList, ErrorMessage
    └── screens/        → CategoryScreen.kt
```

---

## 🛠️ Tech Stack

| Library | Purpose |
|---|---|
| Jetpack Compose | UI |
| Retrofit | HTTP Client |
| Gson | JSON Parsing |
| Coil | Image Loading |
| Kotlin Coroutines | Async Operations |
| ViewModel + StateFlow | State Management |

---

## 🔄 UiState

A sealed class that represents the 3 possible states of any API call:

```kotlin
sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val errorMessage: String?) : UiState<Nothing>()
}
```

Used in the screen like this:

```kotlin
when (uiState) {
    is UiState.Loading -> CircularProgressIndicator()
    is UiState.Success -> CategoryList(state.data)
    is UiState.Error   -> ErrorMessage(state.errorMessage, onRetry)
}
```

---

## 🚀 Getting Started

1. Clone the repo
```bash
git clone https://github.com/ebrahim5599/Retrofit-with-Compose.git
```

2. Open in **Android Studio Hedgehog** or later

3. Run on emulator or real device (API 24+)

> No API key needed — TheMealDB free tier is used.

---

## 📡 API

Base URL: `https://www.themealdb.com/api/json/v1/1/`

| Endpoint | Description |
|---|---|
| `GET /categories.php` | Returns all meal categories |

---

## 📦 Dependencies

```kotlin
// Compose BOM
implementation(platform("androidx.compose:compose-bom:2024.04.00"))

// Retrofit
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Coil
implementation("io.coil-kt:coil-compose:2.6.0")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
```

---

## 👤 Author

**Ibrahim** — [@ebrahim5599](https://github.com/ebrahim5599)
