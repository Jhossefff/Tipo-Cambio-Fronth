export default function Home() {
  return (
    <main>
      <h1>Bienvenido al Sistema de Tipo de Cambio</h1>
      <p>Consulta el tipo de cambio actual o revisa el historial.</p>
      <nav>
        <ul>
          <li>
            <a href="/actual">Tipo de Cambio Actual</a>
          </li>
          <li>
            <a href="/historial">Historial</a>
          </li>
        </ul>
      </nav>
    </main>
  );
}
