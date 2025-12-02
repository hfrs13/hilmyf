TaskManagerGUI

TaskManagerGUI adalah aplikasi berbasis Java dengan antarmuka grafis (GUI) yang dirancang untuk mengelola dan memonitor tugas (task) secara sederhana. Project ini di-upload ke GitHub menggunakan metode Add files via upload, sehingga seluruh struktur project seperti src, nbproject, build, dan dist dapat terlihat secara lengkap.

📌 Fitur Utama

Antarmuka GUI berbasis Java Swing (atau sesuai project Anda).

Menambah, menghapus, atau menampilkan daftar tugas.

Struktur project kompatibel dengan NetBeans.

Mendukung build otomatis menggunakan build.xml.

📁 Struktur Project
TaskManagerGUI/
│
├── build/           # File build otomatis dari NetBeans
├── dist/            # Hasil build berupa .jar
├── nbproject/       # Konfigurasi project NetBeans
├── src/taskmanager/ # Kode sumber utama
├── build.xml        # Script build Ant
└── manifest.mf      # Informasi manifest untuk JAR

🚀 Cara Menjalankan Project

Clone repository:

git clone https://github.com/username/TaskManagerGUI.git


Buka project di NetBeans atau IDE lain yang mendukung Ant.

Jalankan project melalui menu Run.

Atau jalankan file .jar di folder dist:

java -jar TaskManagerGUI.jar

📦 Cara Build Ulang

Jika menggunakan Ant:

ant clean build

📝 Catatan

Project ini diunggah pertama kali menggunakan fitur Upload files GitHub, ditandai dengan commit message "Add files via upload". Seluruh file sudah berada dalam struktur yang sama seperti di lingkungan pengembangan lokal.

📄 Lisensi

Tambahkan lisensi jika diperlukan (misalnya MIT, Apache, atau GPL).
