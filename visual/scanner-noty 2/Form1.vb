Public Class Form1
    Private Sub IniciarToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles IniciarToolStripMenuItem.Click
        Shell("java -jar " & Application.StartupPath & "\scanner.jar", AppWinStyle.Hide, False)
        Notificacion.BalloonTipText = "Iniciando Digitalizador"
        Notificacion.ShowBalloonTip(5000)
        'Notificacion.Visible = True
    End Sub



    Private Sub DetenerToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles DetenerToolStripMenuItem.Click
        Dim opcion As DialogResult
        opcion = MessageBox.Show("¿Estas seguro de detener servicio de scaner?",
                                 "Detener ",
                                 MessageBoxButtons.YesNo,
                                 MessageBoxIcon.Question)
        If (opcion = DialogResult.Yes) Then
            Shell("wmic process where ""name like '%Java%'"" delete")
            Notificacion.BalloonTipText = "Deteniendo Digitalizador"
            Notificacion.ShowBalloonTip(5000)
        End If

    End Sub

    Private Sub SalirToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles SalirToolStripMenuItem.Click
        Dim opcion As DialogResult
        opcion = MessageBox.Show("¿Estas seguro de salir servicio de scaner? " & vbCrLf & " Esto puede ocacionar que deje de trabajar el software de forma correcta",
                                 "Detener ",
                                 MessageBoxButtons.YesNo,
                                 MessageBoxIcon.Question)
        If (opcion = DialogResult.Yes) Then
            Notificacion.BalloonTipText = "Cerrando Digitalizador"
            Notificacion.ShowBalloonTip(5000)
            Me.Close()
        End If

    End Sub

    Private Sub AcercaDeToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles AcercaDeToolStripMenuItem.Click
        Me.Show()
    End Sub
    Private Sub Button_Click(sender As Object, e As EventArgs) Handles Button.Click
        Me.Hide()
        Notificacion.Visible = True
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Shell("java -jar " & Application.StartupPath & "\scanner.jar", AppWinStyle.Hide, False)
        Me.Hide()
        My.Computer.Registry.CurrentUser.OpenSubKey("SOFTWARE\Microsoft\Windows\CurrentVersion\Run", True).SetValue(Application.ProductName, Application.ExecutablePath)
        Notificacion.BalloonTipText = "Iniciando Digitalizador"
        Notificacion.Text = "Software de digitalizacion"
        Notificacion.ShowBalloonTip(5000)
        Notificacion.Visible = True
    End Sub
    Private Sub Form1_()
        Me.Hide()
        Notificacion.Visible = True
    End Sub

    Private Sub Label1_Click(sender As Object, e As EventArgs) Handles Label1.Click

    End Sub
End Class